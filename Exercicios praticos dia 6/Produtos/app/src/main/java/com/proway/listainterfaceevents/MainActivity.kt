package com.proway.listainterfaceevents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.proway.listainterfaceevents.adapter.ProdutosAdapter
import com.proway.listainterfaceevents.interfaces.ClickableProduto
import com.proway.listainterfaceevents.model.Produto
import java.util.*

class MainActivity : AppCompatActivity(), ClickableProduto {

    /**
     * Variável que irá receber a instacia do recyclerView que vem do xml
     */
    private lateinit var recyclerView: RecyclerView
    private lateinit var produtosAdapter: ProdutosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Usamos o mutable lista para conseguir trabalhar com a lista depois (add, remove, etc)
         */


        val listaDeProdutos = mutableListOf<Produto>(
            Produto(UUID.randomUUID().toString(), "Wisky", 79.99f),
            Produto(UUID.randomUUID().toString(), "Cerveja", 3.99f),
            Produto(UUID.randomUUID().toString(), "Cuca", 12.99f),
            Produto(UUID.randomUUID().toString(), "Bruscheta", 14.99f),
            Produto(UUID.randomUUID().toString(), "Wisky", 89.99f),
        )
        /**
         * Inicializamos a instancia do nosso Adapter passando o array como parametro
         */
        produtosAdapter = ProdutosAdapter(listaDeProdutos, this)

        /**
         * Varialvel recyclerView está recebendo o recycler view que vem do xml
         */
        recyclerView = findViewById(R.id.listaDeProdutosRecyclerView)
        /**
         * Define a forma que a lista irá trabalhar
         * (GRID, LINEAR, SCROLL VERTICAL OU HORIZONTAL)
         */
        recyclerView.layoutManager = LinearLayoutManager(this)

        /**
         * Add o adapter no recycler View
         */
        recyclerView.adapter = produtosAdapter

    }

    /**
     * Será chamado de dentro do nosso adapter
     */
    override fun onClickDelete(positon: Int, produto: Produto) {
        Snackbar.make(recyclerView, "DELETE at:$positon --- ${produto.nome}", Snackbar.LENGTH_LONG)
            .show()
    }

    /**
     * Será chamado de dentro do nosso adapter
     */
    override fun onClickEdit(produto: Produto) {
        Snackbar.make(recyclerView, "EDIT: ${produto.nome}", Snackbar.LENGTH_LONG).show()
    }

}