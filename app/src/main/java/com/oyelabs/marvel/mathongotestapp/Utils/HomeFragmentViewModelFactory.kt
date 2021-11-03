package com.oyelabs.marvel.mathongotestapp.Utils

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.oyelabs.marvel.mathongotestapp.Repository.Repository
import com.oyelabs.marvel.mathongotestapp.ViewModels.HomeFragmentViewmodel
import java.lang.IllegalArgumentException

class HomeFragmentViewModelFactory(val repository: Repository,val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewmodel::class.java)) {
            return HomeFragmentViewmodel(repository = repository,application) as T
        }
        throw IllegalArgumentException("viewmodel class not found")
    }
}