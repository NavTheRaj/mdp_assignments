package com.example.assignment2

class User{

    val firstName: String
    val lastName: String
    val username: String
    val password: String
    constructor(firstName: String, lastName: String, username: String, password: String) {
        this.firstName = firstName
        this.lastName = lastName
        this.username = username
        this.password = password
    }
}


object UsersList {
    private val users = ArrayList<User>()

    fun getUsers(): ArrayList<User> {
        return users
    }

    fun addUser(user: User) {
        users.add(user)
    }

    fun addUsers(users: List<User>) {
        users.forEach { user -> addUser(user) }
    }
}



