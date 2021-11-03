package com.oyelabs.marvel.mathongotestapp.Retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder().baseUrl("https://testscoretracker.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClient()).build()
        }

        val testApi: TestApi by lazy {
            retrofit.create(TestApi::class.java)
        }
    }
}