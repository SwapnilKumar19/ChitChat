package com.androiddev.chitchat

class User {
    var name : String? = null
<<<<<<< HEAD
    var phone : String? = null
=======
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
    var email : String? = null
    var uid : String? = null

    constructor(){}

<<<<<<< HEAD
    constructor(name:String?,phone:String?,email:String?,uid:String?){
        this.name = name
        this.phone = phone
=======
    constructor(name:String?,email:String?,uid:String?){
        this.name = name
>>>>>>> a6fa56d0a45eef10e12c905be8aeb0b6dabe0106
        this.email = email
        this.uid = uid
    }

}