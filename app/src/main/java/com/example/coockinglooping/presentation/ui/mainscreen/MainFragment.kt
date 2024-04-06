package com.example.coockinglooping.presentation.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coockinglooping.databinding.MainFragmentBinding
import com.example.coockinglooping.presentation.model.DishPL
import com.example.coockinglooping.presentation.ui.mainscreen.adapter.DishAdapter
import com.example.coockinglooping.presentation.ui.mainscreen.state.MainScreenState
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModel
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModelFactory

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
        get() = _binding ?: throw RuntimeException("binding == null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = DishAdapter()
        val factory = MainScreenViewModelFactory(requireContext())
        val viewModel = ViewModelProvider(this, factory)[MainScreenViewModel::class.java]
        viewModel.loadDataFromDataBase()
        binding.apply {
            recyclerDishes.layoutManager = LinearLayoutManager(requireContext())
            recyclerDishes.adapter = adapter

        }
        viewModel.stateList.observe(viewLifecycleOwner) {
            when (it) {
                is MainScreenState.Loading -> {

                }

                is MainScreenState.Error -> {
//                    snackBarMessageShow("Ошибочка")
                }

                is MainScreenState.Data -> {
                    adapter.submitList(it.data as List<DishPL>)
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding == null
    }

}