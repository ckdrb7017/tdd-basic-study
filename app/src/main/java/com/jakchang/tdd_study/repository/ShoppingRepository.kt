package com.jakchang.tdd_study.repository

import androidx.lifecycle.LiveData
import com.jakchang.tdd_study.data.local.ShoppingItem
import com.jakchang.tdd_study.data.remote.response.ImageResponse
import com.jakchang.tdd_study.other.Resource
import retrofit2.Response

interface ShoppingRepository {
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}