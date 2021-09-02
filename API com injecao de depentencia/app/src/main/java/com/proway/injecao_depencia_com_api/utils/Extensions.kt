package com.proway.injecao_depencia_com_api.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.proway.injecao_depencia_com_api.R

fun FragmentActivity.replaceView(fragement: Fragment, @IdRes containerId: Int = R.id.container){
    supportFragmentManager.beginTransaction()
        .replace(containerId, fragement)
        .commitNow()
}