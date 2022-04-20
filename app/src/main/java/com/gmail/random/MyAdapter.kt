package com.gmail.random

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gmail.random.databinding.ItemNumberBinding

class MyAdapter : ListAdapter<Int, MyAdapter.MyViewHolder>(ItemDiffCallback) {

    class MyViewHolder(
        private val binding: ItemNumberBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(number: Int) {
            binding.number.text = number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(ItemNumberBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object ItemDiffCallback : DiffUtil.ItemCallback<Int>() {

    override fun areItemsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Int, newItem: Int): Boolean {
        return oldItem == newItem
    }
}