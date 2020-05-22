package database

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.yoga.tinderapp.api.ApiClient
import com.yoga.tinderapp.api.ApiInterface
import com.yoga.tinderapp.api.model.SearchResponse
import database.dao.SongDao
import database.tables.SongTable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import utils.Utils

class Repository(val application: Application) {
    private var apiService: ApiInterface? = null
    private var songsList: MutableLiveData<List<SongTable>>
    private var loaderLiveData: MutableLiveData<Boolean>
    private var songDao: SongDao


    init {
        songDao = AppDatabase.getDatabase(application).songDao()
        apiService = ApiClient.client?.create(ApiInterface::class.java)
        songsList = MutableLiveData()
        loaderLiveData = MutableLiveData(false)

    }

    fun getSearchResult(searchTerm: String) {
        var list: ArrayList<SongTable> = arrayListOf()
        if (Utils.isNetworkAvailable(application)) {
            loaderLiveData.value = true
            val call: Call<SearchResponse>? = apiService?.searchSong(searchTerm)
            call?.enqueue(object : Callback<SearchResponse> {
                override fun onResponse(
                    call: Call<SearchResponse>,
                    searchResponse: Response<SearchResponse>
                ) {
                    if (searchResponse.isSuccessful) {
                        if (searchResponse.body().getResults().size > 0) {
                            for (i in 0 until searchResponse.body().getResults().size) {
                                var songTable = SongTable(
                                    0, searchResponse.body().getResults().get(i).getWrapperType(),
                                    searchResponse.body().getResults().get(i).getArtistName(),
                                    searchResponse.body().getResults().get(i).getTrackName(),
                                    searchResponse.body().getResults().get(i).getArtworkUrl100(),
                                    searchResponse.body().getResults().get(i).getCollectionName()
                                )
                                list.add(songTable)
                                songsList.value = list
                            }
                        }

                        loaderLiveData.value = false
                    }
                }

                override fun onFailure(
                    call: Call<SearchResponse>?,
                    t: Throwable?
                ) {
                    loaderLiveData.value = false
                }
            })
        } else {
//            Fetch from local database.
            loaderLiveData.value = true
            songDao.findByName(searchTerm).observeForever(Observer {
                songsList.value = it
            })
            loaderLiveData.value = false
        }
    }

    fun getSongsListLiveData(): LiveData<List<SongTable>> {
        return songsList
    }

    suspend fun insertAll(songsList: ArrayList<SongTable>) {
        songDao.insertAll(*songsList.toTypedArray())
    }

    fun getLoaderLiveData(): LiveData<Boolean> {
        return loaderLiveData
    }
}