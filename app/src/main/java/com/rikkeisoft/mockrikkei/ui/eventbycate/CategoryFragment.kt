package com.rikkeisoft.mockrikkei.ui.eventbycate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.R
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnButtonClickListener
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.databinding.FragmentCategoryBinding
import com.rikkeisoft.mockrikkei.ui.home.popular.adapter.HomePopularAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(), OnItemClickListener<Popular>,
    OnButtonClickListener<Popular> {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCategoryBinding =
        FragmentCategoryBinding::inflate
    private val adapter by lazy {
        HomePopularAdapter(this, this)
    }

    override fun initViews() {
        binding.apply {
            recyclerPopular.adapter = adapter
            buttonBack.setOnClickListener {
                findNavController().popBackStack()
            }
            buttonSearch.setOnClickListener {
                findNavController().navigate(R.id.searchFragment)
            }
        }
    }

    override fun initData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = mutableListOf<Popular>()
            for (i in 0..4) {
                response.add(Popular(i))
            }
            adapter.updateData(response)
        }
    }

    override fun onItemClick(item: Popular) {
        val action = CategoryFragmentDirections.actionCategoryFragmentToEventDetailFragment()
        findNavController().navigate(action)
    }

    override fun onButtonClick(item: Popular) {
        // show bottom popup
    }
}
