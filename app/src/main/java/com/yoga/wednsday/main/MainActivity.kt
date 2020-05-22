package com.yoga.wednsday.main

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import api.model.Result
import com.yoga.wednsday.R
import com.yoga.wednsday.main.adapter.SongsAdapter
import database.tables.SongTable
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.no_data_found.*
import utils.Utils

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    lateinit var songsAdapter: SongsAdapter
    private lateinit var noDataFoundView: LinearLayout
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initView()
        setUpGridView()
        setUpObservers()
        mainViewModel.getSearchResult("%latest%")

    }

    private fun setUpObservers() {
        mainViewModel.getSongsListLiveData().observe(this, Observer {
            if (!it.isNullOrEmpty()) {
                showNoDataView(false)
                songsAdapter.refreshSongsList(it)
                if (Utils.isNetworkAvailable(application)) {
                    mainViewModel.insertAll(it as ArrayList<SongTable>)
                }
            } else {
                showNoDataView(true)
            }
        })

        mainViewModel.getLoaderLiveData().observe(this, Observer {
            showProgressDialog(it)
        })
    }

    private fun setUpGridView() {
        val storyList: List<SongTable> = ArrayList()
        songsAdapter = SongsAdapter(storyList, applicationContext)
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 3)
        recyclerView.adapter = songsAdapter
    }

    private fun initView() {
        progressBar = progress_bar
        recyclerView = recyclerView_songs
        noDataFoundView = linearLayout_no_data_found

        editText_search.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(view: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if ((event != null && (event.keyCode == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_SEARCH)) {
                    if (!editText_search.text.toString().isEmpty())
                        mainViewModel.getSearchResult(editText_search.text.toString())
                    Utils.hideSoftKeyboard(applicationContext, editText_search)
                    return true;
                }
                return false
            }
        })
    }

    private fun showProgressDialog(show: Boolean) {
        if (progressBar != null) {
            if (show) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }

    }

    /**
     * Show no data view
     * @param show <b>true</b> To show the No Data View, <b>false</b> otherwise.
     */
    private fun showNoDataView(show: Boolean) {
        if (show) {
            noDataFoundView.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
        } else {
            noDataFoundView.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        }
    }
}
