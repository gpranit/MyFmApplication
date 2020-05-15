package  com.kotlin.myfmapplication

import android.app.Application
import  com.kotlin.myfmapplication.dagger.AppComponent
import  com.kotlin.myfmapplication.dagger.DaggerAppComponent

class MyFmApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}
