package com.syafii.crudapireqres.controller.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.syafii.crudapireqres.R
import com.syafii.crudapireqres.controller.create.CreateUserActivity
import com.syafii.crudapireqres.controller.listuser.ListUserActivity
import com.syafii.crudapireqres.controller.login.LoginActivity
import com.syafii.crudapireqres.controller.update.UpdateActivity
import com.syafii.crudapireqres.util.openActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_create.setOnClickListener {
            openActivity(CreateUserActivity::class.java)
        }

        btn_list.setOnClickListener {
            openActivity(ListUserActivity::class.java)
        }

        btn_login.setOnClickListener {
            openActivity(LoginActivity::class.java)
        }

        btn_update.setOnClickListener {
            openActivity(UpdateActivity::class.java)
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}