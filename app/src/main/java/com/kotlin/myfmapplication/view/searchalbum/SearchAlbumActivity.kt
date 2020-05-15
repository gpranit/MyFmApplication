package  com.kotlin.myfmapplication.view.searchalbum

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import  com.kotlin.myfmapplication.MyFmApplication
import  com.kotlin.myfmapplication.R
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.Album
import  com.kotlin.myfmapplication.databinding.SearchAlbumDataBinding
import  com.kotlin.myfmapplication.viewmodel.ViewModelProviderFactory
import  com.kotlin.myfmapplication.viewmodel.searchalbum.SearchAlbumViewModel
import javax.inject.Inject

class SearchAlbumActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var searchAlbumDataBinding: SearchAlbumDataBinding
    lateinit var searchAlbumViewModel: SearchAlbumViewModel
    lateinit var albumAdapter: AlbumAdapter
    var albums = ArrayList<Album>();

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyFmApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        searchAlbumDataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_search_album)
        searchAlbumViewModel =
            ViewModelProvider(this, factory).get(SearchAlbumViewModel::class.java)
        searchAlbumDataBinding.setLifecycleOwner(this)
        searchAlbumDataBinding.viewModel = searchAlbumViewModel
        subscribeObservers()
        setupRecyclerView()
    }

    private fun subscribeObservers() {
        searchAlbumViewModel.response.observe(this, Observer {
            albums.clear()
            albums.addAll(it.result.albumMatches.albums)
            albumAdapter.notifyDataSetChanged()

            if (it.result.albumMatches.albums.size == 0) {
                Toast.makeText(this, "No Album match for the searched keyword", Toast.LENGTH_SHORT)
                    .show()
            }

        })
    }

    private fun setupRecyclerView() {
        albumAdapter = AlbumAdapter(albums, this);
        searchAlbumDataBinding.recyclerViewAlbum.adapter = albumAdapter
    }
}