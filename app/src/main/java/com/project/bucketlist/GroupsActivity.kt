package com.project.bucketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.bucketlist.databinding.ActivityGroupsBinding

class GroupsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGroupsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.groupList.layoutManager = LinearLayoutManager(this)

        AppData.initializeData()

        binding.groupList.adapter = GroupListAdapter(AppData.groups, this)

    }

    fun createNewGroup(view: View) {

    }
}