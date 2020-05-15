package com.kotlin.myfmapplication.dataaccesslayer

import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.albumdetail.AlbumDetailResponse
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.SearchAlbumResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyFmApiService {
    @GET("2.0/")
    fun getAlbum(
        @Query("method") method: String,
        @Query("album") album: String,
        @Query("api_key") apiKey: String,
        @Query("format") format: String
    ): Call<SearchAlbumResponse>

    @GET("2.0/")
    fun getAlbumDetail(
        @Query("method") method: String,
        @Query("api_key") apiKey: String,
        @Query("artist") artist: String,
        @Query("album") album: String,
        @Query("format") format: String
    ): Call<AlbumDetailResponse>
}