package com.syafii.crudapireqres.controller.create

import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User
import com.syafii.crudapireqres.model.repository.ApiRest
import com.syafii.crudapireqres.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateUserPresenter (private val view : CreateUserContract.View) : CreateUserContract.Presenter{
    override fun doCreate(user: User) {
        view.showLoading()
        fun getService() = ApiClient.getClient().create(ApiRest::class.java)
        getService().createUser(user).enqueue(object : Callback<ResponseUser>{
            override fun onResponse(call: Call<ResponseUser>, response: Response<ResponseUser>) {
                if (response.isSuccessful && response.body() !=null){
                    view.hideLoading()
                    response.body()?.let { view.showSuccessCreate(it) }
                }else{
                    view.hideLoading()
                    view.showMessage()
                }
            }

            override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                view.hideLoading()
                view.showMessage()
            }
        })
    }

    override fun start() {
        view.initView()
    }
}