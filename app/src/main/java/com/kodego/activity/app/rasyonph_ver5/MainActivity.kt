package com.kodego.activity.app.rasyonph_ver5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.kodego.activity.app.rasyonph_ver5.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding
var dao = UserDatabaseDao()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Binding username and Password button
        binding.btnLogin.setOnClickListener() {

            //LOGIN
            var userName: String = binding.etvUsername.text.toString()
            var password: String = binding.etvPassword.text.toString()
            checkCredential(userName, password)

        }
        binding.tvCreateNewAccount.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "REGISTRATION", Toast.LENGTH_SHORT).show()
        }
    }


    private fun checkCredential(userName: String, password: String): Boolean {
        val correctUserName1: String = "arnel"
        val correctPassword1: String = "12345"

        val correctUserName2: String = "arnel"
        val correctPassword2: String = "12345"


        if ((correctUserName1 == "arnel") && (correctPassword1 == "12345")) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true

        } else if ((correctUserName1 == "arnel") && (correctPassword1 == "12345")) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true

        } else {
            Toast.makeText(applicationContext, "Invalid Credential", Toast.LENGTH_SHORT).show()
            return false
        }
    }
    private fun updateData() {
        var mapData = mutableMapOf<String,String>()
        mapData["username"] = "Username"
        mapData["password"] = "Password"
        dao.update("LoginCredentials",mapData)
    }
        private fun view() {
            dao.get().addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var loginCredentials: ArrayList<UserDatabase> =
                        ArrayList<UserDatabase>()

                    var dataFromDb = snapshot.children

                    for (data in dataFromDb) {
                        // get id of object from DB
                        var id = data.key.toString()

                        var correctUserName = data.child("Username").value.toString()
                        var correctFirstname = data.child("firstname").value.toString()
                        var correctLastname = data.child("lastname").value.toString()
                        var correctEmail = data.child("email").value.toString()
                        var correctMobile = data.child("mobile").value.toString().toLong()
                        var correctCompany = data.child("company").value.toString()
                        var correctAddress = data.child("address").value.toString()
                        var correctPassword = data.child("password").value.toString()


                        var userDatabase = UserDatabase(
                            correctUserName,
                            correctFirstname,
                            correctLastname,
                            correctEmail,
                            correctMobile,
                            correctCompany,
                            correctAddress,
                            correctPassword)

//                        loginCredentials.add(loginCredentials)

                        Toast.makeText(applicationContext,"$id" + userDatabase,Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        }
}
