package com.proway.mynavapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.proway.mynavapp.R
import com.proway.mynavapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        _binding?.extendedClickHereActivity?.setOnClickListener {
            it.findNavController().navigate(R.id.action_nav_home_to_novaActivity)
        }

        _binding?.extendedClickHereToFragment?.setOnClickListener {
            it.findNavController().navigate(R.id.action_nav_home_to_nav_gallery)
        }

        _binding?.extendedClickHereToFragmentNotMapping?.setOnClickListener {
            it.findNavController().navigate(R.id.scrollingFragmentNotMapping)
        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}