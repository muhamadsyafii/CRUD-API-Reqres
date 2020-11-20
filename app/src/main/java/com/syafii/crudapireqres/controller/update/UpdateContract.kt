package com.syafii.crudapireqres.controller.update

import com.syafii.crudapireqres.base.BasePresenter
import com.syafii.crudapireqres.base.BaseView
import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User

interface UpdateContract {
    interface View : BaseView{
        fun showSuccessUpdate(responseUser: ResponseUser)
    }

    interface Presenter : BasePresenter{
        fun doUpdateUser(user: User)
    }
}