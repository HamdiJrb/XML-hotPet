package tn.esprit.smartpet.view

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.smartpet.R
import tn.esprit.smartpet.api.ApiInterface
import tn.esprit.smartpet.model.User

class Signup : AppCompatActivity() {

    var calll = ApiInterface.create()  // call

    lateinit var Email: TextInputEditText
    lateinit var layoutEmail: TextInputLayout

    lateinit var Name: TextInputEditText
    lateinit var layoutName: TextInputLayout

    lateinit var Pwd: TextInputEditText
    lateinit var layoutPwd: TextInputLayout

    lateinit var btn2_sign_up: Button
    lateinit var btn2_sign_in: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        Email = findViewById(R.id.Email)
        layoutEmail = findViewById(R.id.layoutEmail)

        Name = findViewById(R.id.Name)
        layoutName = findViewById(R.id.layoutName)

        Pwd = findViewById(R.id.Pwd)
        layoutPwd = findViewById(R.id.layoutPwd)

        btn2_sign_up = findViewById(R.id.btn2_sign_up)
        btn2_sign_up.setOnClickListener{
            val mainIntent = Intent(this, Signin::class.java)
            startActivity(mainIntent)
        }

        btn2_sign_in = findViewById(R.id.btn2_sign_in)

        btn2_sign_in.setOnClickListener{
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }

        btn2_sign_up.setOnClickListener{
            signUp()
        }
    }
// fct signup
    private fun signUp()
    {
        if (validate())
        {
            val user = User(Email.text.toString(), Pwd.text.toString(),Name.text.toString())
            calll.signup(user).enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        Toast.makeText(
                            this@Signup,
                            "User added successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@Signup, InformationActivity::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        Toast.makeText(
                            this@Signup,
                            "User already exists",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable)
                {
                    Toast.makeText(this@Signup, "Ooooops !! ", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

// fct validate
private fun validate(): Boolean {
    var name=true
    var email=true
    var pwd=true

    layoutName?.error =null
    layoutEmail?.error =null
    layoutPwd?.error =null

    if(Name?.text!!.isEmpty())
    {
        layoutName?.error="Please enter your username!"
        name=false
    }

    if(Email?.text!!.isEmpty())
    {
        layoutEmail?.error="Please enter your e-mail!"
        email=false
    }

    if(Pwd?.text!!.isEmpty())
    {
        layoutPwd?.error="Please enter your password !"
        pwd=false
    }

    if(!Patterns.EMAIL_ADDRESS.matcher(Email?.text!!).matches() && Name?.text!!.isNotEmpty())
    {

        layoutEmail?.error="Email not valid !"
        email= false
    }
    if (name===false || email===false||pwd===false )
    {
        return false
    }
    return true
}
    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }
}