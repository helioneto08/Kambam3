package com.helio.task.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    private val fragmentList = mutableListOf<Fragment>()
    private val titleList = mutableListOf<Int>()

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun addFragment(fragment: Fragment, title: Int) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    fun getTitle(position: Int): Int {
        return titleList[position]
    }
}