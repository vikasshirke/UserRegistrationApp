package com.dtt.userregistrationapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dtt.userregistrationapp.data.entity.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE (email = :emailOrMobile OR mobile = :emailOrMobile) LIMIT 1")
    suspend fun getUser(emailOrMobile: String): User?
}