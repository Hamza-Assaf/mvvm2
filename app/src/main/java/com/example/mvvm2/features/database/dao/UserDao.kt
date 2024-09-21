package com.example.mvvm2.features.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mvvm2.features.database.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAll(): List<User>


    @Insert
    fun insertAll(user: User)

    @Update
     fun updatePassword(user: User)

     @Query(" SELECT EXISTS (SELECT 1 FROM users WHERE email = :email) ")
     fun checkEmailExists(email: String): Boolean

     @Query("SELECT EXISTS (SELECT 1 FROM users WHERE email = :email AND password = :password)")
     fun checkCredentials(email: String, password: String): Boolean

     @Query("SELECT * FROM users WHERE email = :email")
     fun findUserByEmail (email: String): User



}