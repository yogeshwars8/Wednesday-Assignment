package database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import database.tables.SongTable

@Dao
interface SongDao {
    @Query("SELECT * FROM SongTable")
    fun getAll(): List<SongTable>

    @Query("SELECT * FROM SongTable WHERE id IN (:songIds)")
    fun loadAllByIds(songIds: IntArray): List<SongTable>

    @Query(
        "SELECT * FROM SongTable WHERE artistName LIKE :searchTerm OR collectionName LIKE :searchTerm OR trackName LIKE :searchTerm LIMIT 30"
    )
    fun findByName(
        searchTerm: String
    ): LiveData<List<SongTable>>

    /*@Transaction
    open fun updateData(songs: List<SongTable>) {
        insertAll(songs)
    }*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg song: SongTable)

    @Delete
    fun delete(song: SongTable)
}