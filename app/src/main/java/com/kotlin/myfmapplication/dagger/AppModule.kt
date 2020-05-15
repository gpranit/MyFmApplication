package  com.kotlin.myfmapplication.dagger

import android.app.Application
import android.content.Context
import  com.kotlin.myfmapplication.dataaccesslayer.MyFmApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("http://ws.audioscrobbler.com/")
            .build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideMyFmApiService(retrofit: Retrofit): MyFmApiService {
        return retrofit.create(MyFmApiService::class.java)
    }
}