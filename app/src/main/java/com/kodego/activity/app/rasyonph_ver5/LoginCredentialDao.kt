package com.kodego.activity.app.rasyonph_ver5

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginCredentialDao {

    var dbReference: DatabaseReference = Firebase.database.reference

    fun add(loginCredentials: LoginCredentials){
        dbReference.push().setValue(loginCredentials)

    }

    fun get(): Query {
        return dbReference.orderByKey()

    }


}