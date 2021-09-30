package com.rikkeisoft.mockrikkei.ui.mypage.resetpass

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.databinding.FragmentForgetPasswordBinding

class RestPassFragment : BaseFragment<FragmentForgetPasswordBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentForgetPasswordBinding =
        FragmentForgetPasswordBinding::inflate

    override fun initViews() {
        binding.apply {
            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    override fun initData() {
    }
}
