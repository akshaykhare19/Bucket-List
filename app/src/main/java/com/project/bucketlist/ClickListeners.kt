package com.project.bucketlist

interface GroupClickListener {

    fun groupClicked(index: Int)
    fun groupLongClicked(index: Int)

}

interface ItemClickListener {

    fun itemClicked(index: Int)
    fun itemLongClicked(index: Int)

}