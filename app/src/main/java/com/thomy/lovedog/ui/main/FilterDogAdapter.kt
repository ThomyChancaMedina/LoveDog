package com.thomy.lovedog.ui.main

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thomy.domain.Dog
import com.thomy.lovedog.R
import com.thomy.lovedog.databinding.NameListItemBinding
import com.thomy.lovedog.ui.common.basicDiffUtil
import com.thomy.lovedog.ui.common.bindingInflate

class FilterDogAdapter : RecyclerView.Adapter<FilterDogAdapter.ViewHolderDog>() {

    var dogs: List<Dog> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDog =
        ViewHolderDog(parent.bindingInflate(R.layout.name_list_item, false))


    override fun onBindViewHolder(holder: ViewHolderDog, position: Int) {
        val listNameDog = dogs.sortedBy { it.name }
        val dog = listNameDog[position]
        holder.dataBinding.dog = dog
    }

    override fun getItemCount(): Int = dogs.size

    class ViewHolderDog(val dataBinding: NameListItemBinding) :
        RecyclerView.ViewHolder(dataBinding.root)

}