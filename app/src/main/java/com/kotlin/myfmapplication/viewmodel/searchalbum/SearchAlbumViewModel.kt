package com.kotlin.myfmapplication.viewmodel.searchalbum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.SearchAlbumResponse
import  com.kotlin.myfmapplication.dataaccesslayer.repository.AlbumSearchRepository
import javax.inject.Inject

class SearchAlbumViewModel @Inject constructor(private val albumSearchRepository: AlbumSearchRepository) :
    ViewModel() {

    private val TAG = SearchAlbumViewModel::class.simpleName

    val _albumSearchText = MutableLiveData<String>()

    private val _response = MutableLiveData<SearchAlbumResponse>();
    val response: LiveData<SearchAlbumResponse>
        get() = _response;


    init {
        subscribeObserver()
    }

    private fun subscribeObserver() {
        albumSearchRepository.response.observeForever {
            _response.value = it
        }
    }

    fun doAlbumSearch() {
        _albumSearchText.value?.let { albumSearchRepository.getAlbums(it) }
    }
}