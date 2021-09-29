package com.rikkeisoft.mockrikkei.ui.mypage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyPageFragment : BaseFragment<FragmentMyPageBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMyPageBinding =
        FragmentMyPageBinding::inflate

    override fun initViews() {
        binding.apply {
            buttonLogin.setOnClickListener {
                val action = MyPageFragmentDirections.actionMyPageFragmentToAccountFragment()
                findNavController().navigate(action)
            }
            textSignUp.setOnClickListener {
                val action = MyPageFragmentDirections.actionMyPageFragmentToAccountFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun initData() {
    }
}