package tn.esprit.smartpet.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import tn.esprit.smartpet.R
import tn.esprit.smartpet.api.ApiInterface


class ProfileFragment : Fragment() {

    lateinit var mSharedPref: SharedPreferences
    var call = ApiInterface.create()

    private lateinit var option: ImageView
    private lateinit var profilePic: ImageView
    private lateinit var btn_edit: Button
    private lateinit var username: TextView
    private lateinit var age: TextView
    private lateinit var categorie: TextView
    private lateinit var about_me: TextView
    /*private lateinit var username: TextView
    private lateinit var btn_get: Button
    private lateinit var animated_cat: ImageView*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /*mSharedPref=requireActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)*/

        var rootView : View = inflater.inflate(R.layout.fragment_profile, container, false)


        option = rootView.findViewById(R.id.option)
        option.setOnClickListener {
            activity?.let {
                val intent = Intent(it, OptionActivity::class.java)
                it.startActivity(intent)
            }
        }

        /*profilePic.isEnabled = false
        profilePic.setImageURI(Uri.parse(IMAGE))*/ /*setImageURI(Uri.parse(intent.extras!!.getString(IMAGE)))*/

        /*txtEmail = rootView.findViewById(R.id.txtEmail)
        txtEmail.isEnabled = false
        txtEmail.text = mSharedPref.getString(EMAIL, "").toString()*/
        /*mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE)*/
/////////////////////////////////////////////////
        /* profilePic = rootView.findViewById(R.id.profilePic)
        btn_edit = rootView.findViewById(R.id.btn_edit)
        age = rootView.findViewById(R.id.age)
        categorie = rootView.findViewById(R.id.typeanimal)
        about_me = rootView.findViewById(R.id.about_me) */

        /*val emailPref = mSharedPref.getString("EMAIL", "").toString()
        val user = User (email=emailPref)
        call.getProfileData(user).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.code()==200) {
                    val jsonArray = JSONArray(response)
                    val jsonObject: JSONObject = jsonArray.getJSONObject(0)
                    val name= jsonObject.get("username")*/

                    /*username.text = "Hi there " + response.body()!!.username.toString() + " !"*/
                    /*age.text = response.body()!!.age.toString() + " Yo"
                    categorie.text = response.body()!!.typeanimal.toString()
                    about_me.text = response.body()!!.aboutme.toString()*/
               /* }
                else
                {
                    Toast.makeText(getActivity(), "No infos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable)
            {
                Toast.makeText(getActivity(), "Ooooops !! ", Toast.LENGTH_SHORT).show()
            }
        }) */

        /*showGIF()
        btn_get.setOnClickListener {
            activity?.let {
                val intent = Intent(it, ProfileActivity::class.java)
                it.startActivity(intent)
            }
        }*/

        return rootView
    }

    /*private fun showGIF() {
        Glide.with(this).load(R.drawable.animated_cat).into(animated_cat)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    companion object {
        @JvmStatic
        fun newInstance(age: String) = ProfileFragment().apply {
            arguments = Bundle().apply {
                putString(AGE, age)
            }
        }
    }

}