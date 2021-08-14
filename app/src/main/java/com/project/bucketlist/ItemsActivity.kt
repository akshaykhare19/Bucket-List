package com.project.bucketlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bucketlist.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var binding: ActivityItemsBinding
    private lateinit var itemAdapter: ItemsListAdapter
    private lateinit var thisGroup: Group

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityItemsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedIndex = intent.getIntExtra("groupIndex", 0)
        thisGroup = AppData.groups[selectedIndex]

        //sets textView on the toolbar to the group name
        binding.groupName.text = thisGroup.name

        //sets toolbar as the action bar
        setSupportActionBar(binding.toolbar)

        //to go back to the previous screen
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //to remove activity title from the toolbar
        supportActionBar!!.setDisplayShowTitleEnabled(false)


        binding.itemList.layoutManager = LinearLayoutManager(this)
        itemAdapter = ItemsListAdapter(thisGroup, this)
        binding.itemList.adapter = itemAdapter


    }

    //for back button on the toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun itemClicked(index: Int) {
        thisGroup.items[index].isCompleted = !(thisGroup.items[index].isCompleted)
        itemAdapter.notifyDataSetChanged()
    }

    override fun itemLongClicked(index: Int) {

    }

}