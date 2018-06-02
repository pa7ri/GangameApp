package com.example.gangamesdk

import com.example.gangamesdk.serializer.TopGameDeserializer
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MockResponseInterceptor(private val responses: HashMap<String, String>,
                                private val defaultJsonResponse: String) : Interceptor {
    val MEDIA_TYPE_JSON = MediaType.parse("application/json")

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = getResponseFor(request.url().toString())

        return Response.Builder()
                .body(ResponseBody.create(MEDIA_TYPE_JSON, response))
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(200)
                .message("success")
                .build()
    }

    private fun getResponseFor(url: String) : String {
        return if(responses.containsKey(url)){
            responses[url]!!
        } else defaultJsonResponse
    }
}