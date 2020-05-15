package  com.kotlin.myfmapplication.dataaccesslayer.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import  com.kotlin.myfmapplication.R
import  com.kotlin.myfmapplication.dataaccesslayer.MyFmApiService
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.SearchAlbumResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AlbumSearchRepository @Inject constructor(
    private val context: Context,
    private val myFmApiService: MyFmApiService
) {

    private val TAG = AlbumSearchRepository::class.simpleName

    private val _response = MutableLiveData<SearchAlbumResponse>();
    val response: LiveData<SearchAlbumResponse>
        get() = _response;

    fun getAlbums(album: String) {
        myFmApiService.getAlbum(
            context.getString(R.string.method_album_search),
            album,
            context.getString(R.string.api_key),
            context.getString(R.string.format_json)
        ).enqueue(object : Callback<SearchAlbumResponse> {

            override fun onFailure(call: Call<SearchAlbumResponse>, t: Throwable) {
                //_response.value = "Failre" + t.message
                Log.d(TAG, "OnFailure" + t.toString())
            }

            override fun onResponse(
                call: Call<SearchAlbumResponse>,
                response: Response<SearchAlbumResponse>
            ) {
                Log.d(TAG, response.body().toString())
                _response.value = response.body()
            }
        })
    }
}