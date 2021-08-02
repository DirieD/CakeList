package com.example.mvvm_cakesapi.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DatabaseCakes
    (@PrimaryKey
    var title : String,
      var desc : String,
      var image : String)