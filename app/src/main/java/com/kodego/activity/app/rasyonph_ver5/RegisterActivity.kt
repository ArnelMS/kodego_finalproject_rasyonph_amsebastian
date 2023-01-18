package com.kodego.activity.app.rasyonph_ver5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kodego.activity.app.rasyonph_ver5.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    var dao = UserDatabaseDao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener(){
            dao.add(UserDatabase(
                binding.etUsername.text.toString(),
                binding.etFirstname.text.toString(),
                binding.etLastname.text.toString(),
                binding.etEmail.text.toString(),
                binding.etMobille.text.toString().toLong(),
                binding.etCompany.text.toString(),
                binding.etAddress.text.toString(),
                binding.etPassword.text.toString()))

//                "AMS",
//                "Arnel",
//                "Sebastian",
//                "arnelmsebastian@gmail.com",
//                9998846513,
//                "Kodego",
//                "Philippines",
//                "12345"))
            Toast.makeText(applicationContext,"Successfully created new account!", Toast.LENGTH_SHORT).show()
        }
    }
}