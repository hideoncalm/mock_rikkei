package com.rikkeisoft.mockrikkei.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
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

    override fun initViews() {
        binding.apply {
            viewPager.adapter = homeAdapter
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    override fun initData() {
    }
}
