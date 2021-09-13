package com.proway.curl_routines

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proway.curl_routines.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlin.coroutines.CoroutineContext

class SplashActivity() :
    AppCompatActivity(R.layout.activity_splash) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val teste = CoroutineScope(Dispatchers.Main).async {
            toNextActivity()
        }

        CoroutineScope(Dispatchers.Main).async {
            val result = teste.await()
            if (result)
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }



    private suspend fun toNextActivity(): Boolean {
        delay(3000)
        return true
    }
}
