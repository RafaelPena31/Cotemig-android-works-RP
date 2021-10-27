package com.rp.usermanagerp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.rp.usermanagerp.R
import com.rp.usermanagerp.model.UserModel
import com.rp.usermanagerp.services.UserService

class UserUpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update)

        val txtUpdateScreenInputName = findViewById<TextInputEditText>(R.id.txtUpdateScreenInputName)
        val txtUpdateScreenInputBirthDay = findViewById<TextInputEditText>(R.id.txtUpdateScreenInputBirthDay)
        val txtUpdateScreenInputEmail = findViewById<TextInputEditText>(R.id.txtUpdateScreenInputEmail)
        val txtUpdateScreenInputPassword = findViewById<TextInputEditText>(R.id.txtUpdateScreenInputPassword)
        val btnUpdateFromPanel = findViewById<Button>(R.id.btnUpdateFromPanel)
        val btnEditGoBack = findViewById<Button>(R.id.btnEditGoBack)
        var registerDate: String = ""

        val id = intent.getStringExtra("id")

        UserService().findById(id.toString()){ user ->
            txtUpdateScreenInputName.text = user!!.nome.toEditable()
            txtUpdateScreenInputEmail.text = user.email.toEditable()
            txtUpdateScreenInputBirthDay.text = user.dataNascimento.toEditable()
            txtUpdateScreenInputPassword.text = user.senha.toEditable()
            registerDate = user.dataCadastro!!
        }

        btnEditGoBack.setOnClickListener {
            voltarTelaLista()
        }

        btnUpdateFromPanel.setOnClickListener {
            if(txtUpdateScreenInputBirthDay.text.toString().isNotEmpty() &&
                txtUpdateScreenInputEmail.text.toString().isNotEmpty() &&
                txtUpdateScreenInputName.text.toString().isNotEmpty() &&
                txtUpdateScreenInputPassword.text.toString().isNotEmpty()){

                val user = UserModel(
                    id,
                    txtUpdateScreenInputName.text.toString(),
                    txtUpdateScreenInputBirthDay.text.toString(),
                    txtUpdateScreenInputEmail.text.toString(),
                    txtUpdateScreenInputPassword.text.toString(),
                    registerDate
                )

                UserService().update(id.toString(), user){
                    println("foi")
                    Toast.makeText(this@UserUpdateActivity, "Usuário atualizado com sucesso", Toast.LENGTH_SHORT).show()
                    // voltarTelaLista()
                }

            }else{
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun Any.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this.toString())

    private fun voltarTelaLista(){
        val intent = Intent(this, UserListActivity::class.java)
        startActivity(intent)
    }
}