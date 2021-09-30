package com.rikkeisoft.mockrikkei.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.databinding.FragmentEventDetailBinding

class EventDetailFragment : BaseFragment<FragmentEventDetailBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEventDetailBinding =
        FragmentEventDetailBinding::inflate

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
