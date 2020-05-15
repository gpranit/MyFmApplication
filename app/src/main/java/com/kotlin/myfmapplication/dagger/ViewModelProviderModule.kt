package  com.kotlin.myfmapplication.dagger

import androidx.lifecycle.ViewModelProvider
import  com.kotlin.myfmapplication.viewmodel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelProviderModule {

    @Binds
    abstract fun bindViewModelProviderFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}