package com.androiddev.chitchat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var edtName : EditText
<<<<<<< HEAD
    private lateinit var edtPhone : EditText
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
    private lateinit var edtEmail : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnSignup : Button
    private lateinit var btnLogin : Button

    private lateinit var mAuth : FirebaseAuth
    private lateinit var mDbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()

        edtName = findViewById(R.id.edt_name)
<<<<<<< HEAD
        edtPhone = findViewById(R.id.edt_phone)
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_log)
        btnSignup = findViewById(R.id.btn_sign)

        btnSignup.setOnClickListener {
            val name = edtName.text.toString()
<<<<<<< HEAD
            val phone = edtPhone.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(name,phone,email,password)
        }
    }

    private fun signUp(name:String, phone:String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    addUserToDatabase(name,phone,email,mAuth.currentUser?.uid!!)
=======
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signUp(name,email,password)
        }
    }

    private fun signUp(name:String, email: String, password: String) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    addUserToDatabase(name,email,mAuth.currentUser?.uid!!)
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
                    val intent = Intent(this@SignUpActivity,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUpActivity,"Some Error Occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }

<<<<<<< HEAD
    private fun addUserToDatabase(name: String, phone:String, email: String, uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()

        mDbRef.child("user").child(uid).setValue(User(name, phone, email, uid))
=======
    private fun addUserToDatabase(name: String, email: String, uid: String) {
        mDbRef = FirebaseDatabase.getInstance().getReference()

        mDbRef.child("user").child(uid).setValue(User(name, email, uid))
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
    }

}