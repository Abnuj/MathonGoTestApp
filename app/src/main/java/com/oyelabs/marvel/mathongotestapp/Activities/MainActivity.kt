package com.oyelabs.marvel.mathongotestapp.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.oyelabs.marvel.mathongotestapp.R
import com.oyelabs.marvel.mathongotestapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFramgment =
            supportFragmentManager.findFragmentById(R.id.mainHostFragmentContainer) as NavHostFragment
        navController = navHostFramgment.navController
    }
}