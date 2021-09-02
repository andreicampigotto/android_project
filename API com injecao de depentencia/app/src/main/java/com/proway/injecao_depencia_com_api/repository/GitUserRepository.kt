package com.proway.injecao_depencia_com_api.repository

import com.proway.injecao_depencia_com_api.model.User
import com.proway.injecao_depencia_com_api.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitUserRepository {
    private val serviceRepository = RetrofitService.getUsers()

    fun getUsersList(onComplete: (List<User>?, String?) -> Unit) {
        val call = serviceRepository.getUser()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(
                call: Call<List<User>>,
                response: Response<List<User>>
            ) {
                if (response.body() != null)
                  onComplete(response.body(), null)
                else
                    onComplete(null, "Error")
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                onComplete(null, t.localizedMessage)
            }
        })
    }
}