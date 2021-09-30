package com.rikkeisoft.mockrikkei.ui.home.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.databinding.FragmentHomeNewsBinding
import com.rikkeisoft.mockrikkei.ui.home.news.adapter.HomeNewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
//        viewModel.news.observe(viewLifecycleOwner, {
//            homeAdapter.updateData(it)
//        })
        lifecycleScope.launch(Dispatchers.IO){
            val response = mutableListOf<New>()
            for (i in 0..4) {
                response.add(New(i))
            }
            homeAdapter.updateData(response)
        }
    }

    override fun onItemClick(item: New) {
        // open social media
    }

}
