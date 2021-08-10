package com.project.bucketlist

data class Item(
        val name: String,
        var isCompleted: Boolean
)

data class Group(
        val name: String,
        var items: MutableList<Item>
)