package com.superengine.auth.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.superengine.auth.demo.bean.UserBean
import com.superengine.auth.sdk.SuperRouteUtil
import com.superengine.auth.sdk.bean.UserInfo


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(view: View) {
        Cache.userBean = UserBean.generate()

        SuperRouteUtil.goAuthPage(this, UserInfo(Cache.userBean!!.userId!!,Cache.userBean!!.userName!!,Cache.userBean!!.avatarUrl!!))

//        SuperRouteUtil.goAuthPage(this,
//            UserInfo(Cache.userBean!!.userId!!,Cache.userBean!!.userName!!,Cache.userBean!!.avatarUrl!!),
//            CustomUIAuthActivity::class.java
//        )

//        SuperRouteUtil.goAuthPage(this,
//            UserInfo(Cache.userBean!!.userId!!,Cache.userBean!!.userName!!,Cache.userBean!!.avatarUrl!!),
//            CustomUIAuthActivity2::class.java
//        )
    }
}