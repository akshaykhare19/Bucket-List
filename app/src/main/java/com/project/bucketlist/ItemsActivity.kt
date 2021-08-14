package com.project.bucketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.bucketlist.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityItemsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedIndex = intent.getIntExtra("groupIndex", 0)
        val thisGroup = AppData.groups[selectedIndex]

        //sets textView on the toolbar to the group name
        binding.groupName.text = thisGroup.name

        //sets toolbar as the action bar
        setSupportActionBar(binding.toolbar)

        //to go back to the previous screen
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //to remove activity title from the toolbar
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    //for back button on the toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}