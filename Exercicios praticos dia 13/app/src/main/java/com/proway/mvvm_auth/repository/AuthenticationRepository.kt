package com.proway.mvvm_auth.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthenticationRepository {

    private val auth = FirebaseAuth.getInstance()

    //fun authenticationWithEmailPasswod(email:String, password: String, callback: (FirebaseUser?) -> Unit){}

    fun signInWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?, String?) -> Unit
    ) {
        val task = auth.signInWithEmailAndPassword(email, password)
        task.addOnSuccessListener{ authResult ->
            if (authResult.user != null)
                callback(authResult.user, null)
            else
                callback(null, "Erro no login")
        }
        task.addOnFailureListener{
            callback(null, it.message)
        }
    }


    fun createAccountWithEmailPassword(
        email: String,
        password: String,
        callback: (FirebaseUser?) -> Unit
    ) {
        val task = auth.createUserWithEmailAndPassword(email, password)
        task.addOnSuccessListener { authResult ->
            callback(authResult.user)
        }
    }
}