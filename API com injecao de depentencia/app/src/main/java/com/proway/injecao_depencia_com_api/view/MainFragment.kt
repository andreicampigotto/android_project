package com.proway.injecao_depencia_com_api.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.proway.injecao_depencia_com_api.adapater.UserAdapter
import com.proway.injecao_depencia_com_api.databinding.MainFragmentBinding
import com.proway.injecao_depencia_com_api.model.User
import com.proway.injecao_depencia_com_api.view_model.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private val adapter = UserAdapter()

    private val observerRepository = Observer<List<User>> { repository ->
        adapter.update(repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= MainFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.user.observe(viewLifecycleOwner, observerRepository)
        viewModel.getUserList()
    }

}