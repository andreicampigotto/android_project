package com.proway.projectfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.projectfragments.fragments.PrimeiroFragment
import com.proway.projectfragments.fragments.SegundoFragment
import com.proway.projectfragments.fragments.TerceiroFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PrimeiroFragment())
            .commitNow()

        findViewById<Button>(R.id.buttonFrag1).apply {
            setOnClickListener {
                replaceFrag(PrimeiroFragment())
            }
        }

        findViewById<Button>(R.id.buttonFrag2).apply {
            setOnClickListener {
                replaceFrag(SegundoFragment())
            }
        }

        findViewById<Button>(R.id.buttonFrag3).apply {
            setOnClickListener {
                replaceFrag(TerceiroFragment())
            }
        }
    }


    private fun replaceFrag(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
