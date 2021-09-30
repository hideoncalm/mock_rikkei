package com.rikkeisoft.mockrikkei.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.BaseViewPagerAdapter
import com.rikkeisoft.mockrikkei.databinding.FragmentHomeBinding
import com.rikkeisoft.mockrikkei.ui.home.news.HomeNewsFragment
import com.rikkeisoft.mockrikkei.ui.home.popular.HomePopularFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    private val homeAdapter by lazy {
        BaseViewPagerAdapter(
            listOf(HomeNewsFragment(), HomePopularFragment()),
            listOf("News", "Popular"),
            childFragmentManager
        )
    }

    private val listener = object : TabLayout.OnTabSelectedListener{
        override fun onTabSelected(tab: TabLayout.Tab?) {
            tab?.let {
                if(it.position == 1){
                    val action = HomeFragmentDirections.actionHomeFragmentToCustomDialog()
                    findNavController().navigate(action)
                }
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}

        override fun onTabReselected(tab: TabLayout.Tab?) {}

    }
    override fun initViews() {
        binding.apply {
            viewPager.adapter = homeAdapter
            tabLayout.setupWithViewPager(viewPager)
            tabLayout.addOnTabSelectedListener(listener)
        }
    }

    override fun initData() {
    }
}
