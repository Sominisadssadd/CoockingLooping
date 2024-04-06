package com.example.coockinglooping.presentation.ui.mainscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.coockinglooping.databinding.DishItemBinding
import com.example.coockinglooping.presentation.model.DishPL

class DishAdapter : ListAdapter<DishPL, DishAdapter.DishViewHolder>(DiffUtilsCallBackDish()) {
    inner class DishViewHolder(val binding: DishItemBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DishItemBinding.inflate(inflater, parent, false)
        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.apply {
            Glide.with(holder.itemView)
                .load(item.imageUrl)
                .into(imageViewDish)
            textViewTitle.text = item.name
            textViewDescription.text = item.description.substring(0, 20)
            buttonOrderProduct.text = item.cost
        }
    }
}