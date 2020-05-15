package  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Album(
    val name: String,
    val artist: String,
    val image: List<AlbumImage>,
    val mbid: String
) : Parcelable
