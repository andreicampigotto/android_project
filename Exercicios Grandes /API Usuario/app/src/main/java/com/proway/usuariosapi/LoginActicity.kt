package com.proway.usuariosapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputLayout
import com.proway.usuariosapi.endpoint.RetrofitBuilder
import com.proway.usuariosapi.model.Auth
import com.proway.usuariosapi.model.Credentials
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActicity: AppCompatActivity(), Callback<Auth>{

    private lateinit var inputLogin : TextInputLayout
    private lateinit var inputPassword : TextInputLayout
    private lateinit var buttonLogin: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loadComponents()
        loandEvents()
    }

    private fun loandEvents(){
        buttonLogin.setOnClickListener{
            doLogin()
        }
    }
    private fun doLogin(){
        val username = inputLogin.editText?.text.toString()
        val password = inputPassword.editText?.text.toString()

        val credentials = Credentials(username, password)

        if (credentials.checkUsername() && credentials.checkPassword())
            dispararRequestLogin(credentials)
        else
            snackBar()

    }

    private fun dispararRequestLogin(credentials: Credentials){
        val interfaceDeAuthImplementada = RetrofitBuilder.getAuthenticationService()
        val call = interfaceDeAuthImplementada.login(credentials)
        call.clone().enqueue(this)
    }

    private fun loadComponents(){
        inputLogin = findViewById(R.id.textInputLogin)
        inputPassword = findViewById(R.id.textInputPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
    }

    override fun onResponse(call: Call<Auth>, response: Response<Auth>) {
        TODO("Not yet implemented")
    }

    override fun onFailure(call: Call<Auth>, t: Throwable) {
        snackBar(inputLogin)
    }
}