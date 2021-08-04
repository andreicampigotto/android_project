package com.proway.ciclodevida.extensions

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class extensions {

    //Cria o metodo
    fun AppCompatActivity.ShowMessage(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
    }

    //Metodo para retirar pontos e traco do CPF
    fun String.removeMaskCPF(): String {

        return replace(".", "")
            .replace("-", "")
    }

    //Metodo que adiciona pontos e traco no cpf
    fun String.addMaskCPFWithSubsTring(): String? {
        if (length == 11) {
            return substring(0, 3) + "."
            substring(3, 6) + "."
            substring(6, 9) + "-"
            substring(9, 11)
        }

        return null
    }
}