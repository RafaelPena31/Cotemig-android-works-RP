package com.rp.usermanagerp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.rp.usermanagerp.R
import com.rp.usermanagerp.model.UserModel
import com.rp.usermanagerp.services.UserService

class UserCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_create)

        val txtCreateScreenInputName = findViewById<TextInputEditText>(R.id.txtCreateScreenInputName)
        val txtCreateScreenInputEmail = findViewById<TextInputEditText>(R.id.txtCreateScreenInputEmail)
        val txtCreateScreenInputPassword = findViewById<TextInputEditText>(R.id.txtCreateScreenInputPassword)
        val txtCreateScreenInputBirthDay = findViewById<TextInputEditText>(R.id.txtCreateScreenInputBirthDay)
        val btnRegisterFromPanel = findViewById<Button>(R.id.btnRegisterFromPanel)
        val btnGoBack = findViewById<Button>(R.id.btnGoBack)

        btnGoBack.setOnClickListener {
            listGoBack()
        }

        btnRegisterFromPanel.setOnClickListener {

            if(txtCreateScreenInputName.text.toString().isNotEmpty() &&
                txtCreateScreenInputEmail.text.toString().isNotEmpty() &&
                txtCreateScreenInputBirthDay.text.toString().isNotEmpty() &&
                txtCreateScreenInputPassword.text.toString().isNotEmpty()){
                val user = UserModel(
                    null,
                    txtCreateScreenInputName.text.toString(),
                    txtCreateScreenInputBirthDay.text.toString(),
                    txtCreateScreenInputEmail.text.toString(),
                    txtCreateScreenInputPassword.text.toString(),
                    null)

                try {
                    UserService().create(user){}

                    listGoBack()

                }catch (exception: Exception){
                    println(exception.message)
                }
            }else{
                Toast.makeText(this, "Preencha todos os Campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun listGoBack(){
        val intent = Intent(this, UserListActivity::class.java)
        startActivity(intent)
    }
}