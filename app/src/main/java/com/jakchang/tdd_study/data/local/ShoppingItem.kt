package com.jakchang.tdd_study.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_table")
data class ShoppingItem(
    var name: String, var amount: Int, var price: Float, var imageUrl: String,
    @PrimaryKey
    val id: Int? = null
)