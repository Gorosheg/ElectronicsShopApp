package com.gorosheg.electronicsshopapp.feature.mycart.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.gorosheg.electronicsshopapp.feature.mycart.navigator.MyCartNavigator
import com.gorosheg.electronicsshopapp.feature.mycart.presentation.model.MyCartViewState
import com.gorosheg.mycart.R
import com.gorosheg.mycart.databinding.FragmentMyCartBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyCartFragment : Fragment(R.layout.fragment_my_cart) {

    private val viewModel: MyCartViewModel by viewModel()
    private val navigator: MyCartNavigator by inject()
    private val binding: FragmentMyCartBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.state.onEach(::render).launchIn(lifecycleScope)
    }

    private fun render(state: MyCartViewState) = with(binding) {}

    companion object {
        fun newInstance() = MyCartFragment()
    }
}