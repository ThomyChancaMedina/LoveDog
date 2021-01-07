package com.thomy.lovedog.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.thomy.domain.Dog


@BindingAdapter("items")
fun RecyclerView.setItems(names: List<Dog>?) {
    (adapter as? FilterDogAdapter)?.let {
        it.dogs = names ?: emptyList()
    }
}