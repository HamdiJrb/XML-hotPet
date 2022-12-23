package com.yuyakaido.android.cardstackview.sample

import com.google.gson.annotations.SerializedName

data class Spot(
        @SerializedName("email")
        var email: String,
        @SerializedName("password")
        var password: String,
        @SerializedName("username")
        var name: String? = null,
        @SerializedName("_id")
        var id: String? = null,
        @SerializedName("ProfilePicture")
        var ProfilePicture: String? = null,
        val idd: Long = counter++,
        ) {
    companion object {
        private var counter = 0L
    }
}
