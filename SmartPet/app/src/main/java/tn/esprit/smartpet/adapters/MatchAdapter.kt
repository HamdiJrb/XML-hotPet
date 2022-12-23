package tn.esprit.smartpet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.matchfrag.view.*
import tn.esprit.smartpet.R
import tn.esprit.smartpet.model.User

class MatchAdapter (var users: MutableList<User>) :

    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.matchfrag, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        var filename : String
        holder.itemView.apply {

            filename = users[position].ProfilePicture.toString()
            Glide.with(this)
                .load(filename)
                .into(user_img)
            users_match_name.setText(users[position].name)
        }
        holder.itemView.setOnClickListener{
            // holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
}