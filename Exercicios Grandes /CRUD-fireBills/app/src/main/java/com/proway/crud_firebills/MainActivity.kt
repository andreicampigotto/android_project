package com.proway.crud_firebills

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proway.crud_firebills.databinding.MainActivityBinding
import com.proway.crud_firebills.utils.replaceFragment
import com.proway.crud_firebills.view.CategoryCRUDFrangment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun settingBottomNavigation(){
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigation_category -> {
                    replaceFragment(fragment = CategoryCRUDFrangment.newInstance())
                }
            }
            true
        }
    }
}