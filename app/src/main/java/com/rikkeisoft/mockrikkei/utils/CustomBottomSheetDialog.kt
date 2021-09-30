package com.rikkeisoft.mockrikkei.utils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rikkeisoft.mockrikkei.R
import com.rikkeisoft.mockrikkei.databinding.BottomSheetLayoutBinding
import timber.log.Timber

class CustomBottomSheetDialog : BottomSheetDialogFragment() {

    private var binding: BottomSheetLayoutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding!!.apply {
            textJoin.setOnClickListener {
                textJoin.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_tick,
                    0
                )
                Timber.d(textJoin.text.toString())
                findNavController().popBackStack()
            }
            textMaybe.setOnClickListener {
                textMaybe.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_tick,
                    0
                )
                findNavController().popBackStack()
            }
            textNotJoin.setOnClickListener {
                textNotJoin.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_tick,
                    0
                )
                findNavController().popBackStack()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
