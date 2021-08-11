package com.proway.genericadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        findViewById<Button>(R.id.buttonListaCarros).apply {
            setOnClickListener {
                replaceFrag(GenericFragment.newInstance(TipoLista.CARROS))
            }
        }

        findViewById<Button>(R.id.buttonListaProdutos).apply {
            setOnClickListener {
                replaceFrag(GenericFragment.newInstance(TipoLista.PRODUTOS))
            }
        }
    }

    private fun replaceFrag(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }
}