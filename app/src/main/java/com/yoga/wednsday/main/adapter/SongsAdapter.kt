package com.yoga.wednsday.main.adapter

import android.content.Context
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import api.model.Result
import com.bumptech.glide.Glide
import com.yoga.wednsday.R
import database.tables.SongTable
import kotlinx.android.synthetic.main.item.view.*

class SongsAdapter(
    mStoryList: List<SongTable>,
    mContext: Context
) :
    RecyclerView.Adapter<SongsAdapter.ViewHolder>() {
    private var storyList = mStoryList
    private var context = mContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    fun refreshSongsList(mStoryList: List<SongTable>) {
        storyList = mStoryList
        notifyDataSetChanged()
    }

    /**
     * Get item at position.
     */
    fun getItem(position: Int): SongTable {
        return storyList.get(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val SongTable: SongTable = getItem(position)
        holder.bind(SongTable) {
            //            Click listener for item

        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.image
        private val title: TextView = itemView.title

        fun bind(
            item: SongTable,
            listener: (SongTable) -> Unit
        ) = with(itemView) {
            if (!isEmpty(item.artworkUrl100)) {
                Glide.with(context).load(item.artworkUrl100).into(imageView)
            }
            title.text = item.trackName
            if (item.wrapperType.equals("audiobook")) {
                title.text = "Audiobook"
            }
            setOnClickListener { listener(item) }
        }
    }

}