package  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum

import com.squareup.moshi.Json

data class Result(

    @Json(name = "albummatches")
    val albumMatches: AlbumMatches

)