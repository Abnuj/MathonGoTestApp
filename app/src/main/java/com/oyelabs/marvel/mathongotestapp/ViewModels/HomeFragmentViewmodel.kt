package com.oyelabs.marvel.mathongotestapp.ViewModels

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.oyelabs.marvel.mathongotestapp.Repository.Repository

class HomeFragmentViewmodel(val repository: Repository, application: Application) :
    AndroidViewModel(application) {

    fun showToast() {
        Toast.makeText(getApplication(), "Inside viewmodel baby :)", Toast.LENGTH_SHORT).show()
    }

    suspend fun getStudentTestData(): String? {
        return repository.getStudentTestData()
    }

}