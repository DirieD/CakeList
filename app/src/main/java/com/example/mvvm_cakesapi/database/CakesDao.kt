package com.example.mvvm_cakesapi.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CakesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(cakes:List<DatabaseCakes>)

    @Query("SELECT * FROM DATABASECAKES")
    fun getLocalDBCakes (): LiveData<List<DatabaseCakes>>
}

@Database(entities = [DatabaseCakes::class], version = 3, exportSchema = false)
abstract class CakesDatabase : RoomDatabase(){
    abstract val cakesDao : CakesDao
}