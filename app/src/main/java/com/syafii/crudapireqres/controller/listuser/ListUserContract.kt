package com.syafii.crudapireqres.controller.listuser

import com.syafii.crudapireqres.base.BasePresenter
import com.syafii.crudapireqres.base.BaseView
import com.syafii.crudapireqres.model.listuser.DataItem

interface ListUserContract {
    interface View : BaseView{
        fun showListData(lis: List<DataItem>)

    }

    interface Presenter : BasePresenter {
        fun getListData()
    }
}