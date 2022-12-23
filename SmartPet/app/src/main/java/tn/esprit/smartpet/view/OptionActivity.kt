package tn.esprit.smartpet.view

import android.content.SharedPreferences
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import tn.esprit.smartpet.R
import tn.esprit.smartpet.api.ApiInterface

class OptionActivity : AppCompatActivity() {

    private lateinit var edit_profile: Button
    private lateinit var logout: Button
    private lateinit var blog: Button
    private lateinit var privacy: Button
    private lateinit var rate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        edit_profile = findViewById(R.id.edit_profile)
        logout = findViewById(R.id.log_out)
        blog = findViewById(R.id.blog)
        privacy = findViewById(R.id.privacy)
        rate = findViewById(R.id.rate_us)

        // get the user name
        /*val emailPref = mSharedPref.getString("EMAIL", "").toString()
        val user = User (email=emailPref)
        call.getProfileData(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code()==200) {

                    username.text = "Hi there " + response.body()!!.username.toString() + " !"
                }
                else
                {
                    Toast.makeText(this@ProfileActivity, "No infos", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<User>, t: Throwable)
            {
                Toast.makeText(this@ProfileActivity, "Ooooops !! ", Toast.LENGTH_SHORT).show()
            }
        })*/

        // get the other informations
        /*profilePic.setImageURI(Uri.parse(intent.extras!!.getString(IMAGE)))
        profilePic.setImageURI(Uri.parse(mSharedPref.getString(IMAGE, "").toString()))
        age.text = mSharedPref.getString(AGE, "").toString()*/
    }
}