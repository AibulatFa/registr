package com.example.registr.room
import androidx.room.Database
import  androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        AccountDbEntity::class
    ]

)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getAccountsDao(): AccountsDao
}