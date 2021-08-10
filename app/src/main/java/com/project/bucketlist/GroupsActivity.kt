package com.project.bucketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupsActivity : AppCompatActivity() {

    lateinit var groupList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        groupList = findViewById(R.id.group_list)

        groupList.layoutManager = LinearLayoutManager(this)

        AppData.initializeData()

        groupList.adapter = GroupListAdapter(AppData.groups, this)

    }
}