package com.proway.firebaseapplication.view

import android.content.Intent
import android.os.Bundle
import android.os.UserHandle
import android.provider.ContactsContract
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseUser
import com.proway.firebaseapplication.MainActivity
import com.proway.firebaseapplication.R
import com.proway.firebaseapplication.adapter.BillAdapter
import com.proway.firebaseapplication.model.Bill
import com.proway.firebaseapplication.view_model.ContentViewModel

class ContentFragment: Fragment(R.layout.fragment_content) {

    companion object {
        fun newInstance() = ContentFragment()
    }

    private lateinit var viewModel: ContentViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var userEmailTextView: TextView

    private val adapter = BillAdapter()

    private val observerBills = Observer<List<Bill>> {
        adapter.refresh(it)
    }

    val observerLogin= Observer<FirebaseUser> { user ->
        userEmailTextView.apply {
            text = user.email
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContentViewModel::class.java)


        loadBillsData()
        loadUserData()
    }

    fun loadBillsData(){
        viewModel.fetchBills()
    }

    fun loadUserData(){
        viewModel.fetchCurrentUser()
    }
}