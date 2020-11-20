package com.syafii.crudapireqres.controller.login

import com.syafii.crudapireqres.base.BasePresenter
import com.syafii.crudapireqres.base.BaseView
import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User

interface LoginContract {
    interface View : BaseView{
        fun showSuccessLogin(responseUser: ResponseUser)

    }

    interface Presenter : BasePresenter{
        fun authLogin(user: User)
    }
}