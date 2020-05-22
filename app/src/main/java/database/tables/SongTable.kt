package database.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SongTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "wrapperType") val wrapperType: String?,
    @ColumnInfo(name = "artistName") val artistName: String?,
    @ColumnInfo(name = "trackName") val trackName: String?,
    @ColumnInfo(name = "artworkUrl100") val artworkUrl100: String?,
    @ColumnInfo(name = "collectionName") val collectionName: String?
)