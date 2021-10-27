package com.rp.usermanagerp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.content.edit
import com.google.android.material.textfield.TextInputEditText
import com.rp.usermanagerp.R
import com.rp.usermanagerp.services.UserService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)
        val txtEmailInput = findViewById<TextInputEditText>(R.id.txtEmailInput)
        val txtPasswordInput = findViewById<TextInputEditText>(R.id.txtPasswordInput)

        val sharedPreferences = getSharedPreferences("app", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            if(txtEmailInput.text.toString().isNotEmpty() && txtPasswordInput.text.toString().isNotEmpty()){

                UserService().findAll { users ->
                    val user = users?.find { user ->
                        user.email == txtEmailInput.text.toString() && user.senha == txtPasswordInput.text.toString()
                    }

                    if(user != null){
                        sharedPreferences.edit {
                            putString("id", user.id)
                        }

                        val intent = Intent(this, UserListActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
                    }
                }

            }else{
                Toast.makeText(this, "Preencha todos os Campos", Toast.LENGTH_SHORT).show()
            }
        }

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, UserCreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}