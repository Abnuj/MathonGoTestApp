package com.oyelabs.marvel.mathongotestapp.Repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.oyelabs.marvel.mathongotestapp.DataClass.StudentData
import com.oyelabs.marvel.mathongotestapp.Retrofit.RetrofitInstance
import org.json.JSONObject

class Repository {
    val studentDataList = mutableListOf<StudentData>()
    suspend fun getStudentTestData(): String? {
        val response = RetrofitInstance.testApi.getTestScores(0, 5)
        Log.d("TaskData", "response is : $response ")
        if (response.isSuccessful) {
            val responseString: String = Gson().toJson(response.body())
            val responseJsonData = JSONObject(responseString)
            val studentData = fetchStudentTestDataFromJson(responseJsonData)
            Log.d("TaskData", "response string is : $responseString ")
            return responseString
        }
        return "Data not found"
    }

    private fun fetchStudentTestDataFromJson(responseJsonData: JSONObject): StudentData {
        val testScoresArray = responseJsonData.getJSONArray("testScores")
        var tempStudentData = StudentData()
        for (i in 0 until testScoresArray.length()) {
            val arrayObject = testScoresArray.getJSONObject(i)
            val scores = arrayObject.getJSONObject("scores")
            val physics = scores.getInt("Physics")
            val chemistry = scores.getInt("Chemistry")
            val matheMatics = scores.getInt("Mathematics")
            val id = arrayObject.getString("_id")
            val testSeries = arrayObject.getString("testSeries")
            val testName = arrayObject.getString("testName")
            val serverTestDate = arrayObject.getString("testDate")
            val
            tempStudentData = StudentData(id,testSeries,physics,chemistry,matheMatics,matheMatics+chemistry+physics,testName,testDate)
        }
    }
}