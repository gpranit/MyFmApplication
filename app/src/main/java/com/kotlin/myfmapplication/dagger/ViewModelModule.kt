package  com.kotlin.myfmapplication.dagger

import androidx.lifecycle.ViewModel
import  com.kotlin.myfmapplication.viewmodel.albumdetail.AlbumDetailViewModel
import  com.kotlin.myfmapplication.viewmodel.searchalbum.SearchAlbumViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchAlbumViewModel::class)
    abstract fun bindSearchAlbumViewModel(searchAlbumViewModel: SearchAlbumViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AlbumDetailViewModel::class)
    abstract fun bindAlbumDetailViewModel(albumDetailViewModel: AlbumDetailViewModel): ViewModel
}