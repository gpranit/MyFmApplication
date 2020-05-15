package  com.kotlin.myfmapplication.view.searchalbum

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import  com.kotlin.myfmapplication.R
import  com.kotlin.myfmapplication.dataaccesslayer.datacontract.searchalbum.Album
import  com.kotlin.myfmapplication.databinding.AlbumItemDataBinding
import  com.kotlin.myfmapplication.view.albumdetail.AlbumDetailActivity

class AlbumAdapter(
    private var mAlbums: List<Album>, private val context: Context
) : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            AlbumItemDataBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun getItemCount(): Int {
        return mAlbums.size
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val album = mAlbums.get(position)
        holder.bind(album, context)
    }

    class AlbumViewHolder(private var binding: AlbumItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(album: Album, context: Context) {
            binding.album = album
            binding.albumImage.setOnClickListener {
                val intent: Intent = Intent(context, AlbumDetailActivity::class.java)
                intent.putParcelableArrayListExtra(context.getString(R.string.album_extra), arrayListOf(album))
                context.startActivity(intent)
            }
            binding.executePendingBindings()
        }
    }

}