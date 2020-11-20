package com.syafii.crudapireqres.controller.listuser

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.model.listuser.DataItem
import com.syafii.crudapireqres.util.constants.MESSAGE_ERROR
import com.syafii.crudapireqres.util.hide
import com.syafii.crudapireqres.util.show
import com.syafii.crudapireqres.util.showToast
import kotlinx.android.synthetic.main.activity_list_user.*

class ListUserActivity : AppCompatActivity(), ListUserContract.View{
    private lateinit var presenter: ListUserPresenter
    private lateinit var adapter: ListUserAdapter
    private lateinit var refresh : SwipeRefreshLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)
        refresh = findViewById(R.id.sf_list)
        presenter = ListUserPresenter(this)
        presenter.start()
        presenter.getListData()
    }

    override fun initView() {
        refresh.setOnRefreshListener{
            presenter.getListData()
        }

        btnBack.setOnClickListener{
            finish()
        }
    }

    override fun showLoading() {
        progressBar.show()
    }

    override fun hideLoading() {
        progressBar.hide()
        refresh.isRefreshing = false
    }

    override fun showListData(list: List<DataItem>) {
        adapter = ListUserAdapter(this)
        val linearLayoutManager =
            LinearLayoutManager(this,
                RecyclerView.VERTICAL,
                false
            )
        rv_listUser.layoutManager = linearLayoutManager
        adapter.setListUserData(list)
        rv_listUser.adapter = adapter

    }

    override fun showMessage() {
        showToast(MESSAGE_ERROR)
    }
}