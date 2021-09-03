package com.androiddev.chitchat

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ProfileActivity : AppCompatActivity() {

    private lateinit var name : EditText
    private lateinit var status : EditText
    private lateinit var mAuth : FirebaseAuth

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        mAuth = FirebaseAuth.getInstance()

        name = findViewById(R.id.edt_name)
        status = findViewById(R.id.edt_status)

        name.setText(mAuth.currentUser?.displayName)
        status.setText("Hi there, I am here")

    }

}