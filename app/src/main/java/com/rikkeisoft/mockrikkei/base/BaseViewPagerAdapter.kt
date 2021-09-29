package com.rikkeisoft.mockrikkei.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class BaseViewPagerAdapter(
    private val fragments: List<Fragment>,
    private val titles: List<String>,
    private val fragmentManager: FragmentManager,
    private val behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) : FragmentStatePagerAdapter(fragmentManager, behavior) {

    override fun getCount(): Int = fragments.size

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}