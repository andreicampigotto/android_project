package com.proway.injecao_depencia_com_api.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.proway.injecao_depencia_com_api.model.User
import com.proway.injecao_depencia_com_api.repository.GitUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val gitUserRepository: GitUserRepository
) : ViewModel() {

    private val _user = MutableLiveData<List<User>>()
    val user: LiveData<List<User>> = _user

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getUserList() {
        gitUserRepository.getUsersList { list, error ->
            list.apply {
                _user.value = this
            }
            error.apply {
                _error.value = this
            }
        }
    }
}