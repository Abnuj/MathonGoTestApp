package com.oyelabs.marvel.mathongotestapp.Retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApi {

    @GET("https://testscoretracker.herokuapp.com/test-scores?email=noneuser2183@gmail.com&page=0&limit=5")
    suspend fun getTestScores(
        @Query("page") page: Int = 0,
        @Query("limit") limit: Int = 5
    ):Response<Any>
}