package com.oyelabs.marvel.mathongotestapp.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.oyelabs.marvel.mathongotestapp.Repository.Repository
import com.oyelabs.marvel.mathongotestapp.Utils.HomeFragmentViewModelFactory
import com.oyelabs.marvel.mathongotestapp.ViewModels.HomeFragmentViewmodel
import com.oyelabs.marvel.mathongotestapp.databinding.FragmentHomeFragmentBinding
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class home_fragment : Fragment() {
    lateinit var binding: FragmentHomeFragmentBinding
    lateinit var navController: NavController
    lateinit var homeFragmentViewmodel: HomeFragmentViewmodel
    lateinit var repository: Repository
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        getViewModel()
        getStudentTestData()
        setUpViewsClicks()
    }

    private fun getStudentTestData() {
        Log.d("TaskData", "inside student data")
        lifecycleScope.launch {
            val deferredData: Deferred<String?> = async {
                homeFragmentViewmodel.getStudentTestData()

            }
            val data = deferredData.await()
            Log.d("TaskData", "getStudentTestData:$data ")
        }
    }

    private fun getViewModel() {
        repository = Repository()
        val homeViewmodelFactory =
            HomeFragmentViewModelFactory(repository, requireActivity().application)
        homeFragmentViewmodel =
            ViewModelProvider(this, homeViewmodelFactory).get(HomeFragmentViewmodel::class.java)
    }

    private fun setUpViewsClicks() {
        binding.addScoreBtn.setOnClickListener {
            homeFragmentViewmodel.showToast()
            navController.navigate(home_fragmentDirections.actionHomeFragmentToAddScoreFragment())
        }
    }
}