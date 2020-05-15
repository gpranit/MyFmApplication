package  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum

import com.squareup.moshi.Json

data class AlbumMatches(
    @Json(name = "album")
    val albums : List<Album>
)
