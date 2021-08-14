package com.project.bucketlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.bucketlist.databinding.GroupRowBinding

class GroupListAdapter(private val groups: List<Group>,
                    private val listener: GroupClickListener): RecyclerView.Adapter<GroupListAdapter.GroupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val adapterLayout =
            GroupRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GroupViewHolder(adapterLayout, parent.context)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val currentGroup = groups[position]
        holder.bind(currentGroup)

        holder.itemView.setOnClickListener {
            listener.groupClicked(position)
        }

        holder.itemView.setOnLongClickListener {
            listener.groupLongClicked(position)
            true
        }

    }

    override fun getItemCount() = groups.size

    class GroupViewHolder(private val binding: GroupRowBinding,
                          private val context: Context): RecyclerView.ViewHolder(binding.root) {
        fun bind(group: Group){
            binding.groupName.text = group.name
            binding.noOfItems.text = context.getString(R.string._0_items, group.items.count().toString())
        }
    }
}