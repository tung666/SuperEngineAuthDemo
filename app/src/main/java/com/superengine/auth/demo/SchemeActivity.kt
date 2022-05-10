package com.superengine.auth.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.superengine.auth.sdk.SuperRouteUtil
import com.superengine.auth.sdk.bean.UserInfo

class SchemeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleRoute()
    }

    private fun handleRoute() {
        if (SuperRouteUtil.handleRoute(intent.data)) {
            if (isLogin()) {
                //You are logged in||您已经登录，传递您的app中用户Id等信息，跳转认证页面
                val user = UserInfo(
                    Cache.userBean!!.userId!!,
                    Cache.userBean!!.userName!!,
                    Cache.userBean!!.avatarUrl!!
                )
                // 跳转到默认的认证页面 || Jump to the default authentication page
                SuperRouteUtil.goAuthPage(this, user)

                // 跳转到自定义的认证页面 || Jump to the custom authentication page
                // SuperRouteUtil.goAuthPage(this, user,CustomUIAuthActivity::class.java)

               // 跳转到自定义的认证页面2 || Jump to the custom authentication page
                //  SuperRouteUtil.goAuthPage(this, user,CustomUIAuthActivity2::class.java)

            } else {
                //You haven't logged in yet||您还没有登录，跳转登录
                startActivity(Intent(this, LoginActivity::class.java))
            }
        } else {
            startActivity(Intent(this, MainActivity::class.java))
        }

        finish()
    }

    private fun isLogin(): Boolean {
        return Cache.userBean != null
    }

}