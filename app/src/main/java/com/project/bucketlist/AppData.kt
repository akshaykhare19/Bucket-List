package com.project.bucketlist

class AppData {

    companion object {
        var groups: MutableList<Group> = mutableListOf()

        fun initializeData(){
            val item1 = Item("Bread", true)
            val item2 = Item("Butter", false)

            val item3 = Item("Tap to cross", false)
            val item4 = Item("Long press to delete", true)

            val group1 = Group("Home", mutableListOf(item1, item2))

            val group2 = Group("Training", mutableListOf(item3, item4))

            groups = mutableListOf(group1, group2)
        }

    }

}