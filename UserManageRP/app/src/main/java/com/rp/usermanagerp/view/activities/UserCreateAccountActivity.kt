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

class UserCreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_create_account)

        val txtOutsideCreateScreenInputName = findViewById<TextInputEditText>(R.id.txtOutsideCreateScreenInputName)
        val txtOutsideCreateScreenInputEmail = findViewById<TextInputEditText>(R.id.txtOutsideCreateScreenInputEmail)
        val txtOutsideCreateScreenInputPassword = findViewById<TextInputEditText>(R.id.txtOutsideCreateScreenInputPassword)
        val txtOutsideCreateScreenInputBirthDay = findViewById<TextInputEditText>(R.id.txtOutsideCreateScreenInputBirthDay)
        val btnHaveAccount = findViewById<Button>(R.id.btnHaveAccount)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnHaveAccount.setOnClickListener {
            goBackLogin()
        }

        btnRegister.setOnClickListener {

            if(txtOutsideCreateScreenInputName.text.toString().isNotEmpty() &&
                txtOutsideCreateScreenInputEmail.text.toString().isNotEmpty() &&
                txtOutsideCreateScreenInputBirthDay.text.toString().isNotEmpty() &&
                txtOutsideCreateScreenInputPassword.text.toString().isNotEmpty()){
                val user = UserModel(
                    null,
                    txtOutsideCreateScreenInputName.text.toString(),
                    txtOutsideCreateScreenInputBirthDay.text.toString(),
                    txtOutsideCreateScreenInputEmail.text.toString(),
                    txtOutsideCreateScreenInputPassword.text.toString(),
                    null)

                try {
                    UserService().create(user){}

                    goBackLogin()

                }catch (exception: Exception){
                    println(exception.message)
                }
            }else{
                Toast.makeText(this, "Preencha os Campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun goBackLogin(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}