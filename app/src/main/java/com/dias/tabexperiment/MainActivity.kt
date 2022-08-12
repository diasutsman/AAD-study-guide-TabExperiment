package com.dias.tabexperiment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dias.tabexperiment.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() =  _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.apply {
            tabLayout.apply {
                addTab(tabLayout.newTab().setText(R.string.tab_label1))
                addTab(tabLayout.newTab().setText(R.string.tab_label2))
                addTab(tabLayout.newTab().setText(R.string.tab_label3))
                tabGravity = TabLayout.GRAVITY_FILL
                addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
                    override fun onTabSelected(tab: TabLayout.Tab?) {
                        binding.pager.currentItem = tab?.position as Int
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {

                    }

                })
            }
            pager.apply {
                adapter = PagerAdapter(supportFragmentManager, tabLayout.tabCount)
                addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
            }
        }
    }
}