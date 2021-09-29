package com.rikkeisoft.mockrikkei.ui.mypage.account

import android.view.LayoutInflater
import android.view.ViewGroup
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.BaseViewPagerAdapter
import com.rikkeisoft.mockrikkei.databinding.FragmentAccountBinding
import com.rikkeisoft.mockrikkei.ui.mypage.account.login.LoginFragment
import com.rikkeisoft.mockrikkei.ui.mypage.account.signup.SignUpFragment

class AccountFragment : BaseFragment<FragmentAccountBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAccountBinding =
        FragmentAccountBinding::inflate
    private val adapter by lazy {
        BaseViewPagerAdapter(
            listOf(LoginFragment(), SignUpFragment()), listOf("Login", "Sign Up"),
            childFragmentManager
        )
    }

    override fun initViews() {
        binding.apply {
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    override fun initData() {
    }
}
