package com.proway.mvvm_auth.repository

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.proway.mvvm_auth.model.Conta

class ContaRepository {
    private val dataBase = Firebase.firestore

    fun fetchContas(callback: (List<Conta>?, String?) -> Unit) {
        dataBase.collection("contas")
            .get()
            .addOnSuccessListener { result ->

                val listOf = arrayListOf<Conta>()
                result.forEach {
                    listOf.add(Conta.fromData((it)))
                }
                callback(listOf, null)
            }
            .addOnFailureListener { exception ->
                callback(null, exception.message)
            }
    }
}