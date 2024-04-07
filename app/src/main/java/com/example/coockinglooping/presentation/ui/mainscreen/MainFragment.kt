package com.example.coockinglooping.presentation.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coockinglooping.R
import com.example.coockinglooping.databinding.MainFragmentBinding
import com.example.coockinglooping.presentation.model.DishPL
import com.example.coockinglooping.presentation.ui.mainscreen.adapter.DishAdapter
import com.example.coockinglooping.presentation.ui.mainscreen.state.MainScreenState
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModel
import com.example.coockinglooping.presentation.ui.mainscreen.viewmodel.MainScreenViewModelFactory
import com.example.coockinglooping.presentation.utils.scrollToTop
import com.google.android.material.chip.Chip

class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding: MainFragmentBinding
        get() = _binding ?: throw RuntimeException("binding == null")

    private val viewModelFactory by lazy {
        MainScreenViewModelFactory(requireContext())
    }
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainScreenViewModel::class.java]
    }

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
        viewModel.loadDataFromDataBase()
        binding.apply {
            recyclerDishes.layoutManager = LinearLayoutManager(requireContext())
            recyclerDishes.adapter = adapter

        }
        viewModel.stateList.observe(viewLifecycleOwner) {
            when (it) {
                is MainScreenState.Loading -> {
                    //progressbar крутится
                }

                is MainScreenState.Error -> {
                    //ошибка
                }

                is MainScreenState.Data -> {
                    adapter.submitList(it.data as List<DishPL>)
                    val setOfCategories = mutableSetOf<String>()
                    for (category in it.data as List<DishPL>) {
                        setOfCategories.add(category.category)
                    }
                    setUpChipsCategories(setOfCategories.toList())
                }

            }
        }
        setUpBanner()
    }

    private fun setUpChipsCategories(chips: List<String>) {
        for (item in chips) {
            val chip = Chip(requireContext())
            chip.text = item
            chip.isCheckable = true
            chip.isClickable = true
            val color = R.color.chip_text_color
            chip.setTextColor(requireContext().getColor(color))
            chip.elevation = 10f
            chip.setOnCheckedChangeListener { buttonView, isChecked ->
                val filter = item
                if (isChecked) {
                    viewModel.addFilter(filter)
                    binding.recyclerDishes.scrollToTop()
                    val colorText = R.color.chip_text_selected_color
                    val colorBackground = R.color.chip_background_selected_color
                    chip.setTextColor(requireContext().getColor(colorText))
                    chip.setBackgroundColor(requireContext().getColor(colorBackground))
                } else {
                    viewModel.removeFilter(filter)
                    chip.setTextColor(requireContext().getColor(color))
                    chip.setBackgroundColor(requireContext().getColor(R.color.white))
                    binding.recyclerDishes.scrollToTop()
                }
            }
            binding.chipGroup.addView(chip)
        }
    }

    private fun setUpBanner() {
        val banners = listOf(R.drawable.banner_1, R.drawable.banner_2)
        repeat(2) {
            val view = LayoutInflater.from(requireContext())
                .inflate(R.layout.banner_item, binding.bannerLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.imageViewBanner)
            imageView.setImageResource(banners[it])
            binding.bannerLayout.addView(view)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding == null
    }

}