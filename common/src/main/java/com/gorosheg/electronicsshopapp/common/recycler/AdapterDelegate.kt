package com.gorosheg.electronicsshopapp.common.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.gorosheg.electronicsshopapp.common.ListItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

inline fun <reified Item : ListItem, reified Binding : ViewBinding> adapter(
    noinline viewBinding: (layoutInflater: LayoutInflater, root: ViewGroup, attachToParent: Boolean) -> Binding,
    noinline block: context(Binding) AdapterDelegateViewBindingViewHolder<Item, Binding>.() -> Unit = { },
): CommonAdapter {
    return CommonAdapter(adapterDelegate(viewBinding, block))
}

inline fun <reified Item : ListItem, reified Binding : ViewBinding> adapterDelegate(
    noinline viewBinding: (layoutInflater: LayoutInflater, root: ViewGroup, attachToParent: Boolean) -> Binding,
    noinline block: context(Binding) AdapterDelegateViewBindingViewHolder<Item, Binding>.() -> Unit = { },
): AdapterDelegate<List<ListItem>> {
    return adapterDelegateViewBinding<Item, ListItem, Binding>(
        viewBinding = { layoutInflater, parent -> viewBinding.invoke(layoutInflater, parent, false) },
        block = { block.invoke(binding, this) },
    )
}