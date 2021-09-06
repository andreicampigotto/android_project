package com.proway.curl_routines

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.proway.curl_routines.databinding.MainActivityBinding
import com.proway.curl_routines.ui.main.MainFragment


class MainActivity : AppCompatActivity(R.layout.main_activity) {

    private lateinit var binding : MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Maneira de chamar a view para esse contexto
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment.newInstance())
            .commitNow()
    }





}