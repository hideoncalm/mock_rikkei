package com.rikkeisoft.mockrikkei.ui.main

import androidx.core.view.isVisible
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rikkeisoft.mockrikkei.R
import com.rikkeisoft.mockrikkei.base.BaseActivity
import com.rikkeisoft.mockrikkei.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun initViews() {
        setTheme(R.style.Theme_MockRikkei)
        setUpBottomNavigation()
    }

    override fun initListener() {
    }

    private fun setUpBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNav.isVisible = destination.id in mainFragment
        }

        binding.bottomNav.apply {
            setupWithNavController(navController)
            selectedItemId = R.id.homeFragment
            setOnItemReselectedListener { }
        }
    }

    companion object {
        private val mainFragment = listOf(
            R.id.homeFragment,
            R.id.nearFragment,
            R.id.browseFragment,
            R.id.myPageFragment
        )
    }

}