package com.rikkeisoft.mockrikkei.ui.home.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnButtonClickListener
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.databinding.FragmentHomePopularBinding
import com.rikkeisoft.mockrikkei.ui.home.popular.adapter.HomePopularAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomePopularFragment : BaseFragment<FragmentHomePopularBinding>(),
    OnItemClickListener<Popular>, OnButtonClickListener<Popular> {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomePopularBinding =
        FragmentHomePopularBinding::inflate
    private val homeAdapter by lazy {
        HomePopularAdapter(this, this)
    }
    private val viewModel: HomePopularViewModel by viewModels()

    override fun initViews() {
        binding.recyclerPopular.adapter = homeAdapter
    }

    override fun initData() {
        viewModel.popular.observe(viewLifecycleOwner, {
//            homeAdapter.updateData(it)
            Timber.d(it.size.toString())
        })
    }

    override fun onItemClick(item: Popular) {
        Timber.d("Click")
    }

    override fun onButtonClick(item: Popular) {
        Timber.d("Button")
    }

}
