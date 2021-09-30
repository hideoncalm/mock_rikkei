package com.rikkeisoft.mockrikkei.ui.home.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnButtonClickListener
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.databinding.FragmentHomePopularBinding
import com.rikkeisoft.mockrikkei.ui.home.HomeFragmentDirections
import com.rikkeisoft.mockrikkei.ui.home.popular.adapter.HomePopularAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomePopularFragment : BaseFragment<FragmentHomePopularBinding>(),
    OnItemClickListener<Popular>, OnButtonClickListener<Popular> {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomePopularBinding =
        FragmentHomePopularBinding::inflate
    private val homeAdapter by lazy {
        HomePopularAdapter(this, this)
    }
//    private val viewModel: HomePopularViewModel by viewModels()

    override fun initViews() {
        // check login
        binding.recyclerPopular.adapter = homeAdapter
    }

    override fun initData() {
//        viewModel.popular.observe(viewLifecycleOwner, {
//            homeAdapter.updateData(it)
//        })

        lifecycleScope.launch(Dispatchers.IO) {
            val response = mutableListOf<Popular>()
            for (i in 0..4) {
                response.add(Popular(i))
            }
            homeAdapter.updateData(response)
        }
    }

    override fun onItemClick(item: Popular) {
        val action = HomeFragmentDirections.actionHomeFragmentToEventDetailFragment()
        findNavController().navigate(action)
    }

    override fun onButtonClick(item: Popular) {
        val action = HomeFragmentDirections.actionHomeFragmentToCustomBottomSheetDialog()
        findNavController().navigate(action)
    }

}
