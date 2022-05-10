package com.superengine.auth.demo.bean

class UserBean(
    var userId: String? = null,
    var userName: String? = null,
    var avatarUrl: String? = null
) {
    companion object {
        fun generate(): UserBean {
            return UserBean(
                userId = System.currentTimeMillis().toString(),
                userName = "TestUser",
                avatarUrl = "https://c-ssl.duitang.com/uploads/item/201702/06/20170206204000_eNiGY.thumb.1000_0.jpeg"
            )
        }
    }
}