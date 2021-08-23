package com.proway.mvvm_auth.model

data class User(
    val email: String,
    val senha: String,
    val validaSenha: String,
    val nome : String
){
    fun validaEmail(): Boolean{
        if (email.contains("@"))
            return true
        return false
    }

    fun validaSenha(): Boolean{
        if (senha.length > 6)
            return true
        return false
    }

    fun validaTamanhoNome(): Boolean{
        if (nome.length > 1)
            return true
        return false
    }

}
