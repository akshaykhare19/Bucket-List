package com.project.bucketlist

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.bucketlist.databinding.ActivityGroupsBinding
import com.project.bucketlist.databinding.GroupRowBinding

class GroupListAdapter(private val groups: List<Group>,
                    private val context: Context): RecyclerView.Adapter<GroupListAdapter.GroupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val adapterLayout =
            GroupRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return GroupViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val currentGroup = groups[position]
        holder.bind(currentGroup)
    }

    override fun getItemCount() = groups.size

    class GroupViewHolder(private val binding: GroupRowBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(group: Group){
            binding.groupName!!.text = group.name
            binding.noOfItems!!.text = "${group.items.count()} items"
        }

    }
}