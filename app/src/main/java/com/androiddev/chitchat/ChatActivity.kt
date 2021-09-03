package com.androiddev.chitchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
<<<<<<< HEAD
import kotlinx.coroutines.*
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox : EditText
    private lateinit var sendButton : ImageView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageList: ArrayList<Message>

    private lateinit var mDbRef : DatabaseReference

    var receiverRoom : String? = null
    var senderRoom : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

<<<<<<< HEAD
        supportActionBar?.title = intent.getStringExtra("name")

=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
        mDbRef = FirebaseDatabase.getInstance().getReference()

        val name = intent.getStringExtra("name")
        val receiverUid = intent.getStringExtra("uid")

        var senderUid = FirebaseAuth.getInstance().currentUser?.uid
        senderRoom = receiverUid + senderUid
        receiverRoom = senderUid + receiverUid

        supportActionBar?.title = name

<<<<<<< HEAD


=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
        chatRecyclerView = findViewById(R.id.chatRecyclerView)
        messageBox = findViewById(R.id.messageBox)
        sendButton = findViewById(R.id.send_button)

        messageList = ArrayList()
        messageAdapter = MessageAdapter(this,messageList)

        chatRecyclerView.layoutManager = LinearLayoutManager(this)
        chatRecyclerView.adapter = messageAdapter

<<<<<<< HEAD
        messageBox.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    chatRecyclerView.scrollToPosition(messageAdapter.itemCount - 1)

                }
            }
        }

=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106

        mDbRef.child("chats").child(senderRoom!!).child("messages")
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot){

                    messageList.clear()

                    for(postSnapShot in snapshot.children){
                        val message = postSnapShot.getValue(Message::class.java)
                        messageList.add(message!!)
                    }
                    messageAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })


        sendButton.setOnClickListener {
            val message = messageBox.text.toString()
            val messageObject =  Message(message,senderUid)

            mDbRef.child("chats").child(senderRoom!!).child("messages").push()
                .setValue(messageObject).addOnSuccessListener {
                    mDbRef.child("chats").child(receiverRoom!!).child("messages").push()
                        .setValue(messageObject)
                }
<<<<<<< HEAD
            chatRecyclerView.scrollToPosition(messageAdapter.itemCount - 1)
            messageBox.setText("")
        }
    }
    override fun onStart() {
        super.onStart()
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                chatRecyclerView.scrollToPosition(messageAdapter.itemCount - 1)
            }
        }
    }
=======
            messageBox.setText("")
        }
    }
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
}