package  com.kotlin.myfmapplication.dagger

import android.app.Application
import  com.kotlin.myfmapplication.view.albumdetail.AlbumDetailActivity
import  com.kotlin.myfmapplication.view.searchalbum.SearchAlbumActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelModule::class, ViewModelProviderModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(searchAlbumActivity: SearchAlbumActivity)

    fun inject(albumDetailActivity: AlbumDetailActivity)

}
