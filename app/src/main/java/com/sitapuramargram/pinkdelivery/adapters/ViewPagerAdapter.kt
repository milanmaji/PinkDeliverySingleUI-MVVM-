package com.sitapuramargram.pinkdelivery.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sitapuramargram.pinkdelivery.model.Data
import com.sitapuramargram.pinkdelivery.ui.CategoryFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, var dataList: List<Data>) : FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
       return dataList.size
    }

    override fun createFragment(position: Int): Fragment {

        return CategoryFragment(dataList[position].items)
    }

}