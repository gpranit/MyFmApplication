package  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum

import com.squareup.moshi.Json

data class SearchAlbumResponse(

    @Json(name = "results")
    val result: Result

)