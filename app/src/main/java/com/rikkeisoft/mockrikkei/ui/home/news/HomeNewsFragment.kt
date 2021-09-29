package com.rikkeisoft.mockrikkei.ui.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.databinding.FragmentHomeNewsBinding
import com.rikkeisoft.mockrikkei.ui.home.news.adapter.HomeNewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeNewsFragment : BaseFragment<FragmentHomeNewsBinding>(), OnItemClickListener<New> {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeNewsBinding =
        FragmentHomeNewsBinding::inflate
    private var homeAdapter = HomeNewsAdapter(this)
    private val viewModel: HomeNewViewModel by viewModels()

    override fun initViews() {
        binding.recyclerNews.adapter = homeAdapter
    }

    override fun initData() {
        viewModel.apply {
            news.observe(viewLifecycleOwner, {
                Timber.d(it.size.toString())
            })
        }
    }

    override fun onItemClick(item: New) {
        Timber.d("Click")
    }

}
