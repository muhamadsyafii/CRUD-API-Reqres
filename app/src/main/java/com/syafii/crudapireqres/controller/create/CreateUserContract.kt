package com.syafii.crudapireqres.controller.create

import com.syafii.crudapireqres.base.BasePresenter
import com.syafii.crudapireqres.base.BaseView
import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User

interface CreateUserContract {
    interface View : BaseView{
        fun showSuccessCreate(responseUser: ResponseUser)
    }

    interface Presenter : BasePresenter{
        fun doCreate(user : User)
    }
}