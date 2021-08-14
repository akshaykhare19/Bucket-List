package com.project.bucketlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bucketlist.databinding.ActivityGroupsBinding

class GroupsActivity : AppCompatActivity(), OnGroupClickListener {

    private lateinit var binding: ActivityGroupsBinding
    private var groupsAdapter: GroupListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGroupsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.groupList.layoutManager = LinearLayoutManager(this)

        AppData.initializeData()

        groupsAdapter = GroupListAdapter(AppData.groups, this)
        binding.groupList.adapter = groupsAdapter

    }

    fun createNewGroup(v: View) {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("New Group")
        builder.setMessage("Enter the name of your new group here!")

        val input = EditText(this)
        input.inputType = InputType.TYPE_CLASS_TEXT
        builder.setView(input)

        builder.setPositiveButton("Save") { dialog, _->
            val groupName = input.text.toString()
            val newGroup = Group(groupName, mutableListOf())

            AppData.groups.add(newGroup)

            //notifyDataSetChanged can also be used
            groupsAdapter!!.notifyItemChanged(AppData.groups.count())
        }

        builder.setNegativeButton("Cancel") { dialog, _->
            dialog.dismiss()
        }

        builder.setCancelable(false)


        val dialog = builder.create()
        dialog.show()

    }

    override fun groupClicked(index: Int) {
        val intent = Intent(this, ItemsActivity::class.java)

        intent.putExtra("groupIndex", index)

        startActivity(intent)
    }

    override fun groupLongClicked(index: Int) {
        //Delete the group
    }


}