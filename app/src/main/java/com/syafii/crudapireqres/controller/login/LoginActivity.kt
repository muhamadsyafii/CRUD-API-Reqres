package com.syafii.crudapireqres.controller.login

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User
import com.syafii.crudapireqres.util.constants.MESSAGE_ERROR
import com.syafii.crudapireqres.util.hide
import com.syafii.crudapireqres.util.hideKeyboard
import com.syafii.crudapireqres.util.show
import com.syafii.crudapireqres.util.showToast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {
    private lateinit var presenter: LoginPresenter
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this)
        presenter.start()
    }

    override fun initView() {
        btn_login.setOnClickListener {
            hideKeyboard()
            if (et_email.text.isNotEmpty() && et_password.text.isNotEmpty()) {
                val email = et_email.text.toString()
                val pass = et_password.text.toString()

                user = User(null, null, email, pass)

                presenter.authLogin(user)
            } else {
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

    override fun showSuccessLogin(responseUser: ResponseUser) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Success Login")
        dialog.setMessage("Token anda : ${responseUser.token}")
        dialog.setPositiveButton("OK") { dialog, which ->
            finish()
        }
        dialog.show()
    }
}