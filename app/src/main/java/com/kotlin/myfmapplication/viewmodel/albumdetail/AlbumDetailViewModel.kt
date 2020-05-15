package com.kotlin.myfmapplication.viewmodel.albumdetail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import  com.kotlin.myfmapplication.dataaccesslayer.repository.AlbumDetailRepository
import javax.inject.Inject

class AlbumDetailViewModel @Inject constructor(private val albumDetailRepository: AlbumDetailRepository) :
    ViewModel() {

    private val TAG = AlbumDetailViewModel::class.simpleName

    private val _name = MutableLiveData<String>()
    val name: LiveData<String>
        get() = _name

    private val _artist = MutableLiveData<String>()
    val artist: LiveData<String>
        get() = _artist

    private val _listeners = MutableLiveData<String>()
    val listeners: LiveData<String>
        get() = _listeners

    private val _playCount = MutableLiveData<String>()
    val playCount: LiveData<String>
        get() = _playCount

    private val _imageUrl = MutableLiveData<String>()
    val imageUrl: LiveData<String>
        get() = _imageUrl

    init {
        subscribeObservers()
    }

    private fun subscribeObservers() {
        albumDetailRepository.response.observeForever {
            Log.d(TAG, "TRiggered:::::")
            _name.value = it.album.name
            _artist.value = it.album.artist
            _listeners.value = it.album.listeners
            _imageUrl.value = it.album.image.get(2).text
            _playCount.value = it.album.playCount
        }
    }

    fun getAlbumDetail(name: String, artist: String) {
        albumDetailRepository.getAlbumDetail(name, artist)
    }
}