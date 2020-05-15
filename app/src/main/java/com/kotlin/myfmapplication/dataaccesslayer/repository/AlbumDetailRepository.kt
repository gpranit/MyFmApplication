package  com.kotlin.myfmapplication.dataaccesslayer.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import  com.kotlin.myfmapplication.R
import  com.kotlin.myfmapplication.dataaccesslayer.MyFmApiService
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.albumdetail.AlbumDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AlbumDetailRepository @Inject constructor(
    private val context: Context,
    private val myFmApiService: MyFmApiService
) {

    private val TAG = AlbumDetailRepository::class.simpleName

    private val _response = MutableLiveData<AlbumDetailResponse>()
    val response: LiveData<AlbumDetailResponse>
        get() = _response


    fun getAlbumDetail(name: String, artist: String) {
        myFmApiService.getAlbumDetail(
            context.getString(R.string.method_album_getinfo),
            context.getString(R.string.api_key),
            artist,
            name,
            context.getString(R.string.format_json)
        ).enqueue(object : Callback<AlbumDetailResponse> {

            override fun onFailure(call: Call<AlbumDetailResponse>, t: Throwable) {
                //_response.value = "Failre" + t.message
                Log.d(TAG, "OnFailure" + t.toString())
            }

            override fun onResponse(
                call: Call<AlbumDetailResponse>,
                response: Response<AlbumDetailResponse>
            ) {
                Log.d(TAG, response.body().toString())
                _response.value = response.body()
            }
        })
    }
}