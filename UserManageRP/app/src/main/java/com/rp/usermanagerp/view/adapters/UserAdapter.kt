package com.rp.usermanagerp.view.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.rp.usermanagerp.R
import com.rp.usermanagerp.model.UserModel
import com.rp.usermanagerp.services.UserService
import com.rp.usermanagerp.view.activities.UserUpdateActivity

class UserAdapter(
    private val context: Context,
    private val listUser: ArrayList<UserModel>,
    private val notify: () -> Unit
) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvUserBirth = view.findViewById<TextView>(R.id.tvUserBirth)
        val tvUserEmail = view.findViewById<TextView>(R.id.tvUserEmail)
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val btnUserDelete = view.findViewById<ImageButton>(R.id.btnUserDelete)
        val btnUpdateUser = view.findViewById<ImageButton>(R.id.btnUpdateUser)
        val listUserItem = view.findViewById<ConstraintLayout>(R.id.listUserItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = listUser[position]
        val shared = context.getSharedPreferences("app", Context.MODE_PRIVATE)
        val id = shared.getString("id", "")

        holder.apply {
            tvUserName.text = user.nome
            tvUserBirth.text = user.dataNascimento
            tvUserEmail.text = user.email

            btnUserDelete.setOnClickListener {
                UserService().delete(user.id!!.toString()){
                    notify()
                }
            }

            btnUpdateUser.setOnClickListener {
                val intent = Intent(context, UserUpdateActivity::class.java)
                intent.putExtra("id", user.id)
                context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}