package tn.esprit.smartpet.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import tn.esprit.smartpet.R
import tn.esprit.smartpet.model.NAME

class EntranceActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var userName: TextView
    lateinit var roomname: EditText
    lateinit var button: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        userName=findViewById(R.id.userName)
        roomname=findViewById(R.id.roomname)
        button=findViewById(R.id.button)

        val name = intent.getStringExtra(NAME)
        userName.text = name

        button.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.button -> enterChatroom()
        }
    }

    private fun enterChatroom(){
        val userName = userName.text.toString()
        val roomName = roomname.text.toString()

        if(!roomName.isNullOrBlank()&&!userName.isNullOrBlank()) {
            val intentchatroom = Intent(this@EntranceActivity, ChatRoomActivity::class.java)
            intentchatroom.putExtra("userName",userName)
            intentchatroom.putExtra("roomName",roomName)
            startActivity(intentchatroom)

        }else{
            Toast.makeText(this,"Nickname and Roomname should be filled!", Toast.LENGTH_SHORT)
        }
    }
}