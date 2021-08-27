package com.proway.crud_firebills.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.proway.crud_firebills.R
import com.proway.crud_firebills.view_model.MainViewModel

class CategoryCRUDFrangment: Fragment(R.layout.category_crud_fragment) {

    companion object{
        fun newInstance() = CategoryCRUDFrangment()
    }

    private lateinit var viewModel: ViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

}