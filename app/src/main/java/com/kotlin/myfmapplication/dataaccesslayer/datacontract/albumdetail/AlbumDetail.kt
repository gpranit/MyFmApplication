package  com.kotlin.myfmapplication.dataaccesslayer.datacontract.albumdetail

import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.AlbumImage
import com.squareup.moshi.Json

data class AlbumDetail(
    val name: String,
    val artist: String,
    val mbid: String = "",
    val image: List<AlbumImage>,
    val listeners: String,
    @Json(name = "playcount") val playCount: String
)
