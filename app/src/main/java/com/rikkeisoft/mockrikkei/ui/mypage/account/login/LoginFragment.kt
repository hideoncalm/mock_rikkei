package com.rikkeisoft.mockrikkei.ui.mypage.account.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.databinding.FragmentLoginBinding
import com.rikkeisoft.mockrikkei.ui.mypage.account.AccountFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding =
        FragmentLoginBinding::inflate

    override fun initViews() {
        binding.apply {
            textResetPass.setOnClickListener {
                val action = AccountFragmentDirections.actionAccountFragmentToRestPassFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun initData() {
    }
}