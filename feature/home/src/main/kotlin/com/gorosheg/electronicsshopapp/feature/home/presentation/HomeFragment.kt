package com.gorosheg.electronicsshopapp.feature.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.electronicsshopapp.feature.home.navigator.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.*
import com.gorosheg.mainscreen.R
import com.gorosheg.mainscreen.databinding.FragmentHomeBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    private val navigator: HomeNavigator by inject()
    private val binding: FragmentHomeBinding by viewBinding()

    private val adapter = CommonAdapter(
        headerDelegate(),
        categoriesDelegate(),
        searchDelegate(),
        headerDelegate(),
        hotSalesDelegate(),
        headerDelegate(),
        bestSellerDelegate()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        viewModel.state.onEach(::render).launchIn(lifecycleScope)
        homeMainRecycler.adapter = adapter
        filterIcon.setOnClickListener { showFilterDialog() }
    }

    private fun render(state: HomeViewState) {
        adapter.items = state.items
        adapter.notifyDataSetChanged()
    }

    private fun showFilterDialog() {
        FilterFragment().show(childFragmentManager, "tag")
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}