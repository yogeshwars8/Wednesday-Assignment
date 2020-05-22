package com.yoga.wednsday.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import api.model.Result
import database.AppDatabase
import database.Repository
import database.tables.SongTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var repository: Repository

    init {
        repository = Repository(application)
    }

    fun getSearchResult(searchTerm: String) {
        repository.getSearchResult("%$searchTerm%")
    }

    fun getSongsListLiveData(): LiveData<List<SongTable>> {
        return repository.getSongsListLiveData()
    }

    fun getLoaderLiveData(): LiveData<Boolean> {
        return repository.getLoaderLiveData()
    }


    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insertAll(songsList: ArrayList<SongTable>) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertAll(songsList)
    }
}