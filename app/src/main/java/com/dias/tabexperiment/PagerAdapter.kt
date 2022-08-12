package com.dias.tabexperiment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class PagerAdapter(fm: FragmentManager, private val numOfTabs: Int) : FragmentStatePagerAdapter(fm){

    override fun getCount(): Int {
        return numOfTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> TabFragment1()
            1 -> TabFragment2()
            else -> TabFragment3()
        }
    }
}