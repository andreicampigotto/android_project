package com.proway.crud_firebills.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.proway.crud_firebills.R
import com.proway.crud_firebills.databinding.CategoryCrudFragmentBinding
import com.proway.crud_firebills.model.Category
import com.proway.crud_firebills.view_model.MainViewModel

class CategoryCRUDFrangment: Fragment(R.layout.category_crud_fragment) {

    companion object{
        fun newInstance() = CategoryCRUDFrangment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: CategoryCrudFragmentBinding
    private var selectedCategory: Category? = null

    var builder = AlertDialog.Builder(it)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CategoryCrudFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.injectContextAndStartDAO(requireContext())

        binding.fabAdd.setOnClickListener {

        }

        //viewModel.categories.observe(viewLifecycleOwner, obsererCategories)
    }


    

//    fun initialData(){
//        viewModel.getCategories()
//        binding.inputIdTextInputLayout.visibility = GONE
//    }

//    fun setValueToField(category: Category){
//        binding.inputCategoryName.editText?.setText(category.name)
//    }

}