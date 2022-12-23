package tn.esprit.smartpet.model
import com.google.gson.annotations.SerializedName
import com.yuyakaido.android.cardstackview.sample.Spot


// 1. Class 3andha nafs l attributs li fi json
data class User(
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
    )