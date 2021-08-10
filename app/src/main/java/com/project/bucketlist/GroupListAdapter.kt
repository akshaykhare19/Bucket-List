package com.project.bucketlist

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupListAdapter(private val groups: List<Group>,
                    private val context: Context): RecyclerView.Adapter<GroupListAdapter.GroupViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val adapterLayout = LayoutInflater.from(context).inflate(R.layout.group_row, parent, false)
        return GroupViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val currentGroup = groups[position]
        holder.bind(currentGroup)
    }

    override fun getItemCount() = groups.size

    class GroupViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private var groupName: TextView? = null
        private var noOfItems: TextView? = null

        init {
            groupName = itemView.findViewById(R.id.group_name)
            noOfItems = itemView.findViewById(R.id.no_of_items)
        }

        fun bind(group: Group){
            groupName!!.text = group.name
            noOfItems!!.text = "${group.items.count()} items"
        }

    }
}