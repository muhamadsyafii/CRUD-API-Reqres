package com.syafii.crudapireqres.controller.update

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.model.ResponseUser
import com.syafii.crudapireqres.model.User
import com.syafii.crudapireqres.util.constants.MESSAGE_ERROR
import com.syafii.crudapireqres.util.hide
import com.syafii.crudapireqres.util.hideKeyboard
import com.syafii.crudapireqres.util.show
import com.syafii.crudapireqres.util.showToast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnBack
import kotlinx.android.synthetic.main.activity_login.progressBar
import kotlinx.android.synthetic.main.activity_update.*

class UpdateActivity : AppCompatActivity(), UpdateContract.View {
    private lateinit var presenter: UpdatePresenter
    private lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        presenter = UpdatePresenter(this)
        presenter.start()
    }

    override fun initView() {

        btnBack.setOnClickListener {
            finish()
        }

        btn_update.setOnClickListener {
            hideKeyboard()
            if (et_name.text.isNotEmpty() && et_job.text.isNotEmpty()){
                val name = et_name.text.toString()
                val job = et_job.text.toString()

                user = User(name,job,null,null)

                presenter.doUpdateUser(user)
            }else{
                showToast("Please input all data")
            }
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

    override fun showSuccessUpdate(responseUser: ResponseUser) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Success update")
        dialog.setMessage("Name : ${responseUser.name} and Job : ${responseUser.job}")
        dialog.setPositiveButton("OK"){
                dialog, which ->
            finish()
        }
        dialog.show()
    }
}