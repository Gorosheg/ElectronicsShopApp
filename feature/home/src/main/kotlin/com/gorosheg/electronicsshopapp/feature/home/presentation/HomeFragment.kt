package com.gorosheg.electronicsshopapp.feature.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.electronicsshopapp.feature.home.navigator.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.RecyclerItems
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.CommonAdapter
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.headerDelegate
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.searchDelegate
import com.gorosheg.mainscreen.R
import com.gorosheg.mainscreen.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val navigator: HomeNavigator by inject()
    private val binding: FragmentHomeBinding by viewBinding()

    private val adapter = CommonAdapter(
        headerDelegate(),
        searchDelegate(),
        headerDelegate(),
        headerDelegate()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val adapterItems: List<RecyclerItems> = listOf(
                RecyclerItems.Header(title = "Select Category", subtitle = "view all"),
                RecyclerItems.Search,
                RecyclerItems.Header("Hot sales", "see more"),
                RecyclerItems.Header("Best Seller", "see more"),
            )

            adapter.items = adapterItems
            homeMainRecycler.adapter = adapter
            // bestSellerRecycler.layoutManager = GridLayoutManager(requireActivity(), 2)
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}