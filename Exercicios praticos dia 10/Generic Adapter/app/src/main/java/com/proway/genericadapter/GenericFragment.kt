package com.proway.genericadapter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.genericadapter.adapter.GenericAdapter
import com.proway.genericadapter.model.Car
import com.proway.genericadapter.model.Product


class GenericFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    var parametroTipoLista: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.getInt("tipo_lista")?.let {
            parametroTipoLista = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_generic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var listOf = mutableListOf<Any>()
        if (parametroTipoLista == TipoLista.PRODUTOS.id) {
            listOf = mutableListOf(
                Product(1, "Cerveja"),
                Product(2, "Leite"),
                Product(3, "Carne"),
                Product(4, "Fralda"),
                Product(5, "Pizza"),
                Product(6, "Água"),
            )
        } else if (parametroTipoLista == TipoLista.CARROS.id) {
            listOf = mutableListOf(
                Car("Gol", 1994, "Etanol"),
                Car("Celta", 2002, "Etanol"),
                Car("Marajó", 1986, "Etanol"),
                Car("Opala", 2020, "Gasolina"),
                Car("Monza", 1990, "Etanol"),
                Car("Onix", 2011, "Flex"),
                Car("Fusca", 1976, "Gasolina"),
            )
        }
        recyclerView = view.findViewById(R.id.genericRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = GenericAdapter(listOf)
    }


    companion object {
        fun newInstance(tipoLista: TipoLista): GenericFragment {
            return GenericFragment().apply {
                arguments = Bundle().apply {
                    putInt("tipo_lista", tipoLista.id)
                }
            }
        }
    }
}

enum class TipoLista(val id: Int) {
    PRODUTOS(1),
    CARROS(2)
}