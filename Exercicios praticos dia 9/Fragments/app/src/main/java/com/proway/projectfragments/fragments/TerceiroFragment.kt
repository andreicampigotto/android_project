package com.proway.projectfragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.projectfragments.QualquerCoisaLista
import com.proway.projectfragments.R
import com.proway.projectfragments.adapter.ExemploAdapter

class TerceiroFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_terceiro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaQualquerCoisa = mutableListOf<QualquerCoisaLista>(
            QualquerCoisaLista("Papel", "A4"),
            QualquerCoisaLista("Pao", "Fatiado"),
            QualquerCoisaLista("Leite", "Desnatado"),
            QualquerCoisaLista("Geleia", "Uva"),
        )

        recyclerView = view.findViewById(R.id.recliclerViewExemplo)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ExemploAdapter(listaQualquerCoisa)
    }
}
