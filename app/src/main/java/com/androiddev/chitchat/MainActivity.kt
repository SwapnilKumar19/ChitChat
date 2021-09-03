package com.androiddev.chitchat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
<<<<<<< HEAD
import android.widget.Toast
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: UserAdapter
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef : DatabaseReference
<<<<<<< HEAD
    private lateinit var newmsgBtn : FloatingActionButton
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< HEAD

        supportActionBar?.elevation = 0F


        newmsgBtn = findViewById(R.id.newMsgBtn)

        newmsgBtn.setOnClickListener {
            //val intent = Intent(this, LoginActivity::class.java)
            //startActivity(intent)
            Toast.makeText(this,"Not available currently", Toast.LENGTH_SHORT).show()
        }

=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference()

        userList = ArrayList()
        adapter = UserAdapter(this,userList)

        userRecyclerView = findViewById(R.id.userRecyclerView)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = adapter

        mDbRef.child("user").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for(postSnapshot in snapshot.children){
                    val currentUser = postSnapshot.getValue(User::class.java)
                    if(mAuth.currentUser?.uid!=currentUser?.uid){
                        userList.add(currentUser!!)
                    }
                }
                adapter.notifyDataSetChanged()
            } 

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.logout){
            mAuth.signOut()
            val intent = Intent(this@MainActivity,LoginActivity::class.java)
            finish()
            startActivity(intent)
            return true
<<<<<<< HEAD
        }else if(item.itemId == R.id.myProfile){
            val intent = Intent(this@MainActivity,ProfileActivity::class.java)
            startActivity(intent)
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
        }
        return true
    }

}