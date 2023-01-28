package com.jakchang.tdd_study

object RegistrationUtil {

    private val existingUsers = listOf("Peter", "Carl")

    fun validateRegistrationInput(
        userName: String, password: String, confirmedPassword: String
    ): Boolean {
        if (userName.isEmpty() || password.isEmpty()) {
            return false
        }
        if (userName in existingUsers) {
            return false
        }
        if (password != confirmedPassword) {
            return false
        }
        if (password.count { it.isDigit() } < 2) {
            return false
        }

        return true
    }
}