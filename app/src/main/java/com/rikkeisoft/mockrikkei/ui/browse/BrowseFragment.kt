package com.rikkeisoft.mockrikkei.ui.browse

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.R
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnButtonClickListener
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Category
import com.rikkeisoft.mockrikkei.databinding.FragmentBrowseBinding
import com.rikkeisoft.mockrikkei.ui.browse.adapter.BrowserAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BrowseFragment : BaseFragment<FragmentBrowseBinding>(), OnItemClickListener<Category>,
    OnButtonClickListener<Category> {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBrowseBinding =
        FragmentBrowseBinding::inflate
    private val cateAdapter by lazy {
        BrowserAdapter(this, this)
    }

    override fun initViews() {
        binding.apply {
            recyclerGenre.adapter = cateAdapter
            buttonSearch.setOnClickListener {
                findNavController().navigate(R.id.searchFragment)
            }
        }
    }

    override fun initData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val response = mutableListOf<Category>()
            for (i in 0..4) {
                response.add(Category(i, "Music $i"))
            }
            cateAdapter.updateData(response)
        }
    }

    override fun onItemClick(item: Category) {
        val action = BrowseFragmentDirections.actionBrowseFragmentToCategoryFragment()
        findNavController().navigate(action)
    }

    override fun onButtonClick(item: Category) {
        val action = BrowseFragmentDirections.actionBrowseFragmentToCategoryFragment()
        findNavController().navigate(action)
    }
}
