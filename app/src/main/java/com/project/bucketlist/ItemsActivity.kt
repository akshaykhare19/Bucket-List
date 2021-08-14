package com.project.bucketlist

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.bucketlist.databinding.ActivityItemsBinding

class ItemsActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var binding: ActivityItemsBinding
    private var itemAdapter: ItemsListAdapter? = null
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

        binding.inputNewItem.setOnKeyListener { view, keyCode, event ->
            if(keyCode == KeyEvent.KEYCODE_ENTER){
                if(event.action == KeyEvent.ACTION_DOWN){
                    val name = binding.inputNewItem.text.toString()
                    val item = Item(name, false)
                    thisGroup.items.add(item)
                    itemAdapter!!.notifyItemInserted(thisGroup.items.count())
                    binding.inputNewItem.text.clear()

                    //to remove keyboard on entering the enter key
                    val inputManager =
                            getSystemService(Activity.INPUT_METHOD_SERVICE)
                                as InputMethodManager
                    inputManager.hideSoftInputFromWindow(view.windowToken, 0)
                }
            }

            false
        }

    }

    //for back button on the toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun finish() {
        super.finish()

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun itemClicked(index: Int) {
        thisGroup.items[index].isCompleted = !(thisGroup.items[index].isCompleted)
        itemAdapter!!.notifyDataSetChanged()
    }

    override fun itemLongClicked(index: Int) {
        thisGroup.items.removeAt(index)
        itemAdapter!!.notifyItemRemoved(index)
    }

}