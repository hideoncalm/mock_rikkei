package com.rikkeisoft.mockrikkei.ui.home.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rikkeisoft.mockrikkei.data.model.New
import com.rikkeisoft.mockrikkei.data.repository.NewRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeNewViewModel @Inject constructor(
    private val newRepo: NewRepository
) : ViewModel() {

    init {
        getNews()
    }

    private val _news = MutableLiveData<MutableList<New>>()
    val news: LiveData<MutableList<New>>
        get() = _news

    private fun getNews() {
        viewModelScope.launch(Dispatchers.IO) {
//            val response = newRepo.getLocalNews()
//            _news.postValue(response.toMutableList())
            val response = mutableListOf<New>()
            for (i in 0..4) {
                response.add(New(i))
            }
            _news.postValue(response)
            Timber.d(response.size.toString())
        }
    }
}
