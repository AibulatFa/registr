package com.example.registr.room

import androidx.room.Dao;
import androidx.room.Insert
import androidx.room.Query;
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountsDao {

    @Query("SELECT id, password FROM accounts WHERE email = :email")
    suspend fun findByEmail(email: String): AccountSignInTuple?

    @Update(entity = AccountDbEntity::class)
    suspend fun updateUsername(updateUsernameTuple: AccountUpdateUsernameTuple)

    @Insert
    suspend fun  createAccount(accountDbEntity: AccountDbEntity)

    @Query("SELECT * FROM  accounts WHERE id = :accountId")
    fun getById(account: Long): Flow<AccountDbEntity?>
}