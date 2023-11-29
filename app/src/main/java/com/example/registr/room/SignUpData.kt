package com.example.registr.room

import androidx.compose.ui.text.input.KeyboardType.Companion.Email
import ua.cn.stu.room.model.EmptyFieldException
import java.lang.reflect.Field


data class SignUpData(
    val username: String,
    val email: String,
    val password: String,
    )
{
    fun validate() {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (username.isBlank()) throw EmptyFieldException(Field.Username)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)

    }
}