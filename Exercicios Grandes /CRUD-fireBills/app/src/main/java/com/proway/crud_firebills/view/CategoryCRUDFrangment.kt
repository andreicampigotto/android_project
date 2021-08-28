package com.proway.crud_firebills.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.proway.crud_firebills.Adapter.CategoryAdapter
import com.proway.crud_firebills.R
import com.proway.crud_firebills.databinding.CategoryCrudFragmentBinding
import com.proway.crud_firebills.model.Category
import com.proway.crud_firebills.utils.replaceFragment
import com.proway.crud_firebills.view_model.CategoryCRUDViewModel

class CategoryCRUDFrangment: Fragment(R.layout.category_crud_fragment){

    companion object{
        fun newInstance() = CategoryCRUDFrangment()
    }

    private lateinit var viewModel: CategoryCRUDViewModel
    private lateinit var binding: CategoryCrudFragmentBinding
    private var selectedCategory: Category? = null

    private val adapter = CategoryAdapter(){
        this
    }

    private val observerCategories = Observer<List<Category>> {
        adapter.refresh(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = CategoryCrudFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(CategoryCRUDViewModel::class.java)
        viewModel.injectContextAndStartDAO(requireContext())

        binding.fabAdd.setOnClickListener {
            (requireActivity() as? AppCompatActivity)?.replaceFragment(CategoryCreate())
        }

    }
}