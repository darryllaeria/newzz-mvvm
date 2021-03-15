package com.example.newzz.home.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.newzz.base.base_component.BaseFragment
import com.example.newzz.home.R
import com.example.newzz.home.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: BaseFragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private var fragmentHomeBinding: FragmentHomeBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
    }

    override fun onDestroyView() {
        fragmentHomeBinding = null
        super.onDestroyView()
    }

    private fun initUI(view: View) {
        val binding = FragmentHomeBinding.bind(view)
        fragmentHomeBinding = binding
        binding.btnSearch.setOnClickListener {
            Toast.makeText(context, "Button clicked", Toast.LENGTH_LONG).show()
        }
    }

    override fun initLogic() {
        super.initLogic()
    }

    override fun unsubscribeObservers() {
        super.unsubscribeObservers()
    }
}