package com.dtt.userregistrationapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val valid: Int = 0,
    val name: String,
    val email: String,
    val mobile: String,
    val gender: String,
    val age: String,
    var password: String
)