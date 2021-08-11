package com.proway.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.proway.myapplication.fragments.ListaPessoasFragment
import com.proway.myapplication.fragments.ListaProdutosFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<Button>(R.id.buttonListaPessoas).apply {
            setOnClickListener {
                replaceFrag(ListaPessoasFragment())
            }
        }

        findViewById<Button>(R.id.buttonListaProdutos).apply {
            setOnClickListener {
                replaceFrag(ListaProdutosFragment())
            }
        }
    }


    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}