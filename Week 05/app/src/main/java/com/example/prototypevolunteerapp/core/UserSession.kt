package com.example.prototypevolunteerapp.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object UserSession {
    data class User(val name: String, val email: String)
    private val demoAccounts = mapOf(
        // Dummy data dari anggota tim
        "saskyaaliyaazizah06@gmail.com" to Pair("volunteer1", "Saskya Aliya"),
        "mumtatazah@gmail.com"          to Pair("volunteer2", "Mumtazah Nur Hidayati"),
        "sannytazkiyah@gmail.com"       to Pair("volunteer3", "Sanny Tazkiyah"),
        "queennikamutiara@gmail.com"    to Pair("volunteer4", "Queen Nika Prahara")
    )
    var currentUser: User? by mutableStateOf(null)
        private set

    val isLoggedIn get() = currentUser != null

    fun login(email: String, password: String): Boolean {
        val entry = demoAccounts[email.trim().lowercase()]
        return if (entry != null && entry.first == password) {
            currentUser = User(name = entry.second, email = email.trim())
            true
        } else false
    }
    fun logout() { currentUser = null }
}
