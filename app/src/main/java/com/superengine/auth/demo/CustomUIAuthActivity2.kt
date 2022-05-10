package com.superengine.auth.demo

import android.os.Bundle
import com.superengine.auth.sdk.SuperAuthActivity

/**
 * Customize the activity based on your page theme
 * 根据您的页面主题自定义这个activity
 */
class CustomUIAuthActivity2 : SuperAuthActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_auth_custom2)

        superAuth = findViewById(R.id.authView)
        ivBack = findViewById(R.id.ivBack)
        ivBack.setOnClickListener {
            finish()
        }
        initView(superAuth)
    }

}