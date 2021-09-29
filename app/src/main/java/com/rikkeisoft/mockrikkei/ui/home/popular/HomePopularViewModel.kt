package com.rikkeisoft.mockrikkei.ui.home.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rikkeisoft.mockrikkei.data.model.Popular
import com.rikkeisoft.mockrikkei.data.repository.PopularRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomePopularViewModel @Inject constructor(
    private val popularRepo: PopularRepository
) : ViewModel() {

    private val _populars = MutableLiveData<MutableList<Popular>>()
    val popular: LiveData<MutableList<Popular>>
        get() = _populars

    fun getPopulars() {
        viewModelScope.launch(Dispatchers.IO) {
//            val response = popularRepo.getLocalPopulars()
//            _populars.postValue(response.toMutableList())
            val response = mutableListOf<Popular>()
            for (i in 0..4) {
                response.add(Popular(i.toLong()))
            }
            _populars.postValue(response)
        }
    }

}
