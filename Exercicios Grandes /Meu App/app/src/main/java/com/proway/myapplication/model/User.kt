package com.proway.myapplication.model

data class User(
    val cpf: String,
    val pssword: String
) {

    private fun validLenCpf(): Boolean {

        if (this.cpf.length != 11 ||
            this.cpf == "00000000000" || this.cpf == "11111111111" ||
            this.cpf == "22222222222" || this.cpf == "33333333333" ||
            this.cpf == "44444444444" || this.cpf == "55555555555" ||
            this.cpf == "66666666666" || this.cpf == "77777777777" ||
            this.cpf == "88888888888" || this.cpf == "99999999999"
        ) {
            return false
        }
        return true
    }

    fun isValidCpf(): Boolean {

        return if (validLenCpf())
            false
        else
            cpf.length == 11
    }

    fun isValidPssword(): Boolean {
        return pssword.length >= 8
    }
}
