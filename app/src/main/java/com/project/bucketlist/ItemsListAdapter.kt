package com.project.bucketlist

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.bucketlist.databinding.ItemRowBinding

class ItemsListAdapter(private val group: Group,
                    private val listener: ItemClickListener): RecyclerView.Adapter<ItemsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val adapterLayout =
                ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemsViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val currentItem = group.items[position]
        holder.bind(currentItem)

        holder.itemView.setOnClickListener {
            listener.itemClicked(position)
        }

        holder.itemView.setOnLongClickListener {
            listener.itemLongClicked(position)
            true
        }

    }

    override fun getItemCount() = group.items.size
}

class ItemsViewHolder(private val binding: ItemRowBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(toDoItem: Item){
        binding.item.text = toDoItem.name
        binding.itemCheck.isChecked = toDoItem.isCompleted

        if(binding.itemCheck.isChecked){
            //to make the text strike-through
            val strikeText = SpannableString(binding.item.text)
            val strikeThroughSpan = StrikethroughSpan()
            strikeText.setSpan(strikeThroughSpan, 0, binding.item.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
            binding.item.text = strikeText
        }
    }
}
