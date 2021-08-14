package com.project.bucketlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.bucketlist.databinding.ItemRowBinding

class ItemsListAdapter(private val group: Group): RecyclerView.Adapter<ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val adapterLayout =
                ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val currentItem = group.items[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = group.items.size
}

class ItemsViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(toDoItem: Item){
        binding.item.text = toDoItem.name
        binding.itemCheck.isChecked = toDoItem.isCompleted
    }
}
