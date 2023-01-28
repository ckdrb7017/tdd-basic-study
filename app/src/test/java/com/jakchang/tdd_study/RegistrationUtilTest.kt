package com.jakchang.tdd_study

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `empty userName returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `valid userName and correctly repeated password returns true`(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "Philip",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `userName already exists returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "Carl",
            password = "123",
            confirmedPassword = "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is empty returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "Carl",
            password = "",
            confirmedPassword = ""
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is repeated incorrectly returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "Carl",
            password = "123",
            confirmedPassword = "987"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password contains less than 2 digits returns false`(){
        val result = RegistrationUtil.validateRegistrationInput(
            userName = "Carl",
            password = "abcde1",
            confirmedPassword = "abcde1"
        )
        assertThat(result).isFalse()
    }
}