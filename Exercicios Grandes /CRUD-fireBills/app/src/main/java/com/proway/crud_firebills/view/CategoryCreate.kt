package com.proway.crud_firebills.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.proway.crud_firebills.R
import com.proway.crud_firebills.databinding.CategoryCreateFragmentBinding
import com.proway.crud_firebills.model.Category
import com.proway.crud_firebills.view_model.CategoryCRUDViewModel

class CategoryCreate : Fragment(R.layout.category_create_fragment) {

    private lateinit var viewModel: CategoryCRUDViewModel
    private lateinit var binding: CategoryCreateFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // abertura do fragment de insert
        binding = CategoryCreateFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(CategoryCRUDViewModel::class.java)
        setupEventSave()
    }

    private fun setupEventSave() {
        binding.floatingActionButton.setOnClickListener {
            binding.inputCategoryName.editText?.let { edit ->
                if (edit.text.isNotEmpty()) {
                    Category(name = edit.text.toString()).let { category ->
                        viewModel.insertCategory(category)
                        clearFields()
                    }
                }
            }
        }
    }

   private fun clearFields(){
        binding.inputCategoryName.editText?.setText("")
    }
}