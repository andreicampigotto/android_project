package com.firstprojectandroid.classes

import android.text.TextUtils

class Pessoa(
    var nome : String?,
    var eMail: String?
) {
    fun validaEMail(eMail: String): Boolean {
        return !TextUtils.isEmpty(eMail) && android.util.Patterns.EMAIL_ADDRESS.matcher(eMail).matches()
    }

    fun concatenaNome(nome: String): String {

        return "${nome} 26 anos, e-mail: ${eMail}"
    }


}