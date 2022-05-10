package com.superengine.auth.demo.view

import android.app.ProgressDialog
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import com.bumptech.glide.Glide
import com.superengine.auth.demo.R
import com.superengine.auth.sdk.view.SuperAuthView

class CustomAuthView : SuperAuthView {

    var tvName: TextView? = null

    constructor(context: Context?) : super(context) {
        init()
    }


    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    private fun init() {
        loadingDialog = ProgressDialog(context).apply {
            setMessage(context.getString(R.string.authing))
            setCanceledOnTouchOutside(false)
        }

        LayoutInflater.from(context).inflate(layoutId(), this, true)
        ivAvatar = findViewById(R.id.ivAvatar)
        tvName = findViewById(com.superengine.auth.demo.R.id.tvName)
        btnConfirm = findViewById(R.id.btnConfirm)
        btnConfirm?.setOnClickListener {
            authUser()
        }
    }

    override fun layoutId(): Int {
        return R.layout.view_auth_custom
    }

    override fun showLoadingDialog() {
        loadingDialog.show()
    }

    override fun dismissLoadingDialog() {
        loadingDialog.dismiss()
    }

    override fun updateView() {
        tvName?.text = userInfo?.userName ?: ""
        ivAvatar?.let {
            Glide.with(this).load(userInfo?.avatarUrl)
                .placeholder(R.drawable.ic_placeholder_avatar)
                .error(R.drawable.ic_placeholder_avatar)
                .into(it)
        }

    }


}