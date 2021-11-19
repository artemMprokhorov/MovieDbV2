package com.example.moviedb.commons.net

import android.content.Context
import android.os.SystemClock
import android.util.Log.*
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class FakeInterceptor constructor(private val context: Context) : Interceptor {

    private var mContentType = "application/json"

    override fun intercept(chain: Interceptor.Chain): Response {
        SystemClock.sleep(LOAD_TIME)
        val method = chain.request().method.lowercase(Locale.getDefault())
        val defaultFileName: String = getFileName(chain)
        var response: Response? = null
        val uri = chain.request().url.toUri()
        val mockDataPath = uri.host + uri.path + "/".lowercase(Locale.getDefault())
        logMessage(
            "--> Request url: [" + method.uppercase(Locale.getDefault()) + "]" + uri.toString(),
            DEBUG
        )

        kotlin.runCatching {
            logMessage("Read data from file: $mockDataPath + $defaultFileName", DEBUG)
            val jsonFile: String =
                context.assets.open(mockDataPath + defaultFileName).bufferedReader()
                    .use { it.readText() }
            lateinit var jsonObject: Any

            if (jsonFile.trim().first() == '[') {
                jsonObject = JSONArray(jsonFile)
            } else if (jsonFile.trim().first() == '{') {
                jsonObject = JSONObject(jsonFile)
            }

            logMessage("Response: $jsonObject", DEBUG)

            val builder = Response.Builder()
            builder.request(chain.request())
            builder.protocol(Protocol.HTTP_1_0)
            builder.addHeader("content-type", mContentType)
            builder.body(
                jsonObject.toString().toByteArray().toResponseBody(mContentType.toMediaTypeOrNull())
            )
            builder.code(200)
            builder.message(jsonObject.toString())
            response = builder.build()
        }.onFailure { error ->
            logMessage("${error.message} ->> $error", ERROR)
        }
        logMessage(
            "<-- END [" + method.uppercase(Locale.getDefault()) + "]" + uri.toString(),
            DEBUG
        )
        return response!!
    }

    private fun logMessage(message: String, level: Int) {
        when (level) {
            DEBUG -> d(TAG, message)
            else -> e(TAG, message)
        }
    }

    private fun getFileName(chain: Interceptor.Chain): String {
        val fileName =
            chain.request().url.pathSegments[chain.request().url.pathSegments.size - 1]
        return if (fileName.isEmpty()) "index$FILE_EXTENSION" else fileName + "_" + chain.request().method.lowercase(
            Locale.getDefault()
        ) + FILE_EXTENSION
    }

    companion object {
        private val TAG = FakeInterceptor::class.java.simpleName
        private const val FILE_EXTENSION = ".json"
        private const val LOAD_TIME = 1500.toLong()
    }
}