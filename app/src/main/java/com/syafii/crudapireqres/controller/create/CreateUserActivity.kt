package com.syafii.crudapireqres.controller.create

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User
import com.syafii.crudapireqres.util.constants.MESSAGE_ERROR
import com.syafii.crudapireqres.util.hide
import com.syafii.crudapireqres.util.hideKeyboard
import com.syafii.crudapireqres.util.show
import com.syafii.crudapireqres.util.showToast
import kotlinx.android.synthetic.main.activity_create_user.*

class CreateUserActivity : AppCompatActivity(), CreateUserContract.View {

    private lateinit var presenter: CreateUserPresenter
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        presenter = CreateUserPresenter(this)
        presenter.start()
    }

    override fun showSuccessCreate(responseUser: ResponseUser) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Success create user")
        dialog.setMessage("Name : ${responseUser.name} and Job : ${responseUser.job}")
        dialog.setPositiveButton("OK"){
            dialog, which ->
            finish()
        }
        dialog.show()
    }

    override fun initView() {

        btn_Register.setOnClickListener {
            hideKeyboard()
            if (et_name.text.isNotEmpty() && et_job.text.isNotEmpty()){
                val name = et_name.text.toString()
                val job = et_job.text.toString()

                user = User(name,job)

                presenter.doCreate(user)
            }else{
                showToast("Please input all data")
            }
        }

        btnBack.setOnClickListener {
            finish()
        }

    }

    override fun showLoading() {
        progressBar.show()
    }

    override fun hideLoading() {
        progressBar.hide()
    }

    override fun showMessage() {
        showToast(MESSAGE_ERROR)
    }
}