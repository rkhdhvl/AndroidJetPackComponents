package com.practice.androidjetpackcomponents.openapi.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practice.androidjetpackcomponents.openapi.model.AccountProperties

@Dao
interface AccountPropertiesDao  {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAndReplace(accountProperties:AccountProperties) : Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrIgnore(accountProperties: AccountProperties) : Long

    @Query("SELECT * FROM account_properties where pk = :pk")
    fun searchByPk(pk :Int) : AccountProperties?

    @Query("SELECT * FROM account_properties where email = :email")
    fun searchByEmail(email:String) : AccountProperties?

}