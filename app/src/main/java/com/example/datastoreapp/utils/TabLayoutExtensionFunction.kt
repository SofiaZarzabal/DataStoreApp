package com.example.datastoreapp.utils

import androidx.viewpager2.widget.ViewPager2
import com.example.datastoreapp.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

fun TabLayout.setupWithViewPager2(viewPager2: ViewPager2) {
    TabLayoutMediator(this, viewPager2) { tab, position ->
        tab.text = (viewPager2.adapter as ViewPagerAdapter).getPageTitle(position)
    }.attach()
}
