package com.rp.usermanagerp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rp.usermanagerp.R
import com.rp.usermanagerp.services.UserService
import com.rp.usermanagerp.view.adapters.UserAdapter

class UserListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val btnAdd = findViewById<ImageButton>(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val intent = Intent(this, UserCreateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadUserData()
    }

    fun loadUserData(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        UserService().findAll { users ->
            recyclerView.apply {
                adapter = UserAdapter(this@UserListActivity, users!!){
                    loadUserData()
                }

                itemAnimator = DefaultItemAnimator()
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}