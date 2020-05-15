package com.kotlin.myfmapplication.view.albumdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import  com.kotlin.myfmapplication.MyFmApplication
import  com.kotlin.myfmapplication.R
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.Album
import  com.kotlin.myfmapplication.databinding.AlbumDetailDataBinding
import  com.kotlin.myfmapplication.viewmodel.ViewModelProviderFactory
import  com.kotlin.myfmapplication.viewmodel.albumdetail.AlbumDetailViewModel
import javax.inject.Inject

class AlbumDetailActivity : AppCompatActivity() {

    private val TAG = AlbumDetailActivity::class.simpleName

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var albumDetailDataBinding: AlbumDetailDataBinding
    lateinit var albumDetailViewModel: AlbumDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyFmApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        albumDetailDataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_album_detail)
        albumDetailViewModel =
            ViewModelProvider(this, factory).get(AlbumDetailViewModel::class.java)
        albumDetailDataBinding.setLifecycleOwner(this)
        albumDetailDataBinding.viewModel = albumDetailViewModel

        val album = intent.getParcelableArrayListExtra<Album>(getString(R.string.album_extra))
        if(album !=null)
        albumDetailViewModel.getAlbumDetail(album.get(0).name, album.get(0).artist)


    }
}