package  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize data class AlbumImage(
    @Json(name = "#text")
    val text: String,

    val size: String
): Parcelable