package com.example.mvvm2.features.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm2.features.database.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class DataBaseHelper : RoomDatabase(){

    abstract fun userDao(): UserDao


}