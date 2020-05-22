package com.yoga.tinderapp.api.model

import api.model.Result
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchResponse {
    @SerializedName("resultCount")
    @Expose
    private var resultCount: Int? = null
    @SerializedName("results")
    @Expose
    private var results: List<Result> = mutableListOf()

    fun getResultCount(): Int? {
        return resultCount
    }

    fun setResultCount(resultCount: Int?) {
        this.resultCount = resultCount
    }

    fun getResults(): List<Result> {
        return results
    }

    fun setResults(results: List<Result>) {
        this.results = results
    }
}

