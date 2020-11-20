package com.syafii.crudapireqres.controller.listuser

import com.syafii.crudapireqres.model.listuser.DataItem
import com.syafii.crudapireqres.model.listuser.UserResponse
import com.syafii.crudapireqres.model.repository.ApiRest
import com.syafii.crudapireqres.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUserPresenter(private val view: ListUserContract.View) : ListUserContract.Presenter {

    override fun getListData() {
        view.showLoading()
        fun getService() = ApiClient.getClient().create(ApiRest::class.java)
        getService().listUser().enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful && response.body() !=null){
                    view.hideLoading()
                    response.body()?.data.let { view.showListData(it as List<DataItem>) }
                }else{
                    view.hideLoading()
                    view.showMessage()
                }
            }
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                view.hideLoading()
                view.showMessage()
            }
        })
    }

    override fun start() {
        view.initView()
    }
}