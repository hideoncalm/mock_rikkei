package com.rikkeisoft.mockrikkei.ui.near

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rikkeisoft.mockrikkei.base.BaseFragment
import com.rikkeisoft.mockrikkei.base.OnItemClickListener
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.databinding.FragmentNearBinding
import com.rikkeisoft.mockrikkei.ui.near.adapter.NearAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NearFragment : BaseFragment<FragmentNearBinding>(), OnItemClickListener<Popular> {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNearBinding =
        FragmentNearBinding::inflate
    private var map: GoogleMap? = null
    private val adapter by lazy {
        NearAdapter(this)
    }

    override fun initViewWithState(savedInstanceState: Bundle?) {
        super.initViewWithState(savedInstanceState)
        binding.mapView.apply {
            onCreate(savedInstanceState)
            getMapAsync {
                map = it
                val sydney = LatLng(20.97182, 105.77389)
                map?.apply {
                    addMarker(MarkerOptions().position(sydney).title("SQQQQQ"))
                    moveCamera(CameraUpdateFactory.newLatLng(sydney))
                    setMinZoomPreference(15f)
                }
            }
        }
    }

    override fun initViews() {
        binding.recyclerEvent.adapter = adapter
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

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
    }


    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onItemClick(item: Popular) {
        val action = NearFragmentDirections.actionNearFragmentToEventDetailFragment()
        findNavController().navigate(action)
    }
}
