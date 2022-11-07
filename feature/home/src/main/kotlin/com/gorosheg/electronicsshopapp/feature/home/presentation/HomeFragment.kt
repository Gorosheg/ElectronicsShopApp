package com.gorosheg.electronicsshopapp.feature.home.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.electronicsshopapp.feature.home.navigator.HomeNavigator
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.Category
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.HotSale
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.RecyclerItems
import com.gorosheg.electronicsshopapp.feature.home.presentation.recycler.delegate.*
import com.gorosheg.mainscreen.R
import com.gorosheg.mainscreen.databinding.FragmentHomeBinding
import org.koin.android.ext.android.inject


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val navigator: HomeNavigator by inject()
    private val binding: FragmentHomeBinding by viewBinding()

    private val adapter = CommonAdapter(
        headerDelegate(),
        categoriesDelegate(),
        searchDelegate(),
        headerDelegate(),
        hotSalesDelegate(),
        headerDelegate()
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val adapterItems: List<RecyclerItems> = listOf(
                RecyclerItems.Header("Select Category", "view all"),

                RecyclerItems.Categories(listOf(
                    Category("Phones", R.drawable.ic_phones, true),
                    Category("Computer", R.drawable.ic_computer, false),
                    Category("Health", R.drawable.ic_health, false),
                    Category("Books", R.drawable.ic_books, false),
                )),

                RecyclerItems.Search,
                RecyclerItems.Header("Hot sales", "see more"),

                RecyclerItems.HotSales(listOf(
                    HotSale("Iphone 12", "Súper. Mega. Rápido.", true),
                    HotSale("Iphone 45", "qwerty", false)
                )),

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