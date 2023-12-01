package com.example.a1stlab.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "http://universities.hipolabs.com/"

    private var retrofit: Retrofit = createRetrofit(BASE_URL)

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun setBaseUrl(newBaseUrl: String) {
        // Если вы хотите изменить базовый URL, удостоверьтесь, что он заканчивается символом /
        val correctedBaseUrl = if (newBaseUrl.endsWith("/")) newBaseUrl else "$newBaseUrl/"
        retrofit = createRetrofit(correctedBaseUrl)
    }

    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}

