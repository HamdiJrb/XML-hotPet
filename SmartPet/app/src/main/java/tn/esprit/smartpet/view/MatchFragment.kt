package tn.esprit.smartpet.view

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_match.*
import tn.esprit.smartpet.R
import tn.esprit.smartpet.api.ApiInterface
import tn.esprit.smartpet.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tn.esprit.smartpet.adapters.MatchAdapter
//declaration shered
private lateinit var mSharedPref: SharedPreferences

class MatchFragment : Fragment(R.layout.fragment_match) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.fragment_match, container, false)
        return rootView
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requireActivity().window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        progBarMatch.visibility = View.VISIBLE

       //appel
        mSharedPref =  requireContext().getSharedPreferences(PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        val map: HashMap<String, String> = HashMap()
        map["userSwiped"] = mSharedPref.getString(ID, "").toString()
        val apiInterface = ApiInterface.create()
        apiInterface.GetLike(map).enqueue(object :
            Callback<MutableList<User>> {

            override fun onResponse(call: Call<MutableList<User>>, response:
            Response<MutableList<User>>
            ) {
                val matchs = response.body()

                Log.e("matchs : ",matchs.toString())
                if(!matchs.isNullOrEmpty())
                {
                    val adapter = MatchAdapter(matchs)
                    rv_users_matchs.adapter = adapter
                    rv_users_matchs.apply {
                        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,false)
                    }

                }
                else
                {
                    NoMatch.visibility = View.VISIBLE
                }
                progBarMatch.visibility = View.INVISIBLE
                requireActivity().window.clearFlags( WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }

            override fun onFailure(call: Call<MutableList<User>>, t: Throwable) {
                Toast.makeText(context, "Connexion error!", Toast.LENGTH_SHORT).show()
                progBarMatch.visibility = View.INVISIBLE
                requireActivity().window.clearFlags( WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
            }
        })

//function
        super.onViewCreated(view, savedInstanceState)
    }

}