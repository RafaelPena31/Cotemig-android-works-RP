package com.rp.usermanagerp.services.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConnection {
    companion object {
        const val BASE_URL = "https://6177e2279c328300175f5bfe.mockapi.io/api/v1/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}