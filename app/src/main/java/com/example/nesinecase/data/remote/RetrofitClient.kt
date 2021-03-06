package com.example.nesinecase.data.remote

import com.example.nesinecase.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

abstract class RetrofitClient {
    companion object {
        private var INSTANCE: Retrofit? = null

        fun getInstance(): Retrofit {
            return INSTANCE ?: synchronized(this) {
                val instance = Retrofit.Builder()
                    .baseUrl(Constants.POST_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}