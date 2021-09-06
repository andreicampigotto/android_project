package com.proway.curl_routines.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proway.curl_routines.repository.GitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: GitRepository): ViewModel() {

    fun getRepositories(){
        viewModelScope.launch {
            val responseModel = repository.getRepositories().await()
            println(responseModel)
        }
    }
}