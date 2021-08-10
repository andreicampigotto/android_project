package com.proway.usuariosapi.utils

import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.snackBar(view: View, @StringRes resId: Int){
    hideKeyboard()
}