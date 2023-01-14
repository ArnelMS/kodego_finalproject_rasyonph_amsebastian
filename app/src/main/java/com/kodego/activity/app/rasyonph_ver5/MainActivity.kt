package com.kodego.activity.app.rasyonph_ver5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.activity.app.rasyonph_ver5.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Binding username and Password button
        binding.tvCreateNewAccount.setOnClickListener() {

            //LOGIN
            var userName: String = binding.etvUsername.text.toString()
            var password: String = binding.etvPassword.text.toString()
            checkCredential(userName, password)
        }
    }

    private fun checkCredential(userName: String, password: String): Boolean {
        val correctUserName1: String = "admin"
        val correctPassword1: String = "a123"

        val correctUserName2: String = "arnel"
        val correctPassword2: String = "12345"


        if ((correctUserName1 == "admin") && (correctPassword1 == "a123")) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
            Toast.makeText(applicationContext, "Logging in...", Toast.LENGTH_SHORT).show()
            return true

        } else if ((correctUserName2 == "arnel") && (correctPassword2 == "12345")) {
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
}
