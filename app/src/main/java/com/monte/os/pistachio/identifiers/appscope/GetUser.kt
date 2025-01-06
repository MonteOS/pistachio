package com.monte.os.pistachio.identifiers.appscope

object GetUser {
    @JvmStatic
    private external fun getUser(): String

    val username: String

    init {
        System.loadLibrary("getuser")
        username = getUser()
    }
}
