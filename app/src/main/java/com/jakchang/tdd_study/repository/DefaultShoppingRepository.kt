package com.jakchang.tdd_study.repository

import androidx.lifecycle.LiveData
import com.jakchang.tdd_study.data.local.ShoppingDao
import com.jakchang.tdd_study.data.local.ShoppingItem
import com.jakchang.tdd_study.data.remote.PixabayAPI
import com.jakchang.tdd_study.data.remote.response.ImageResponse
import com.jakchang.tdd_study.other.Resource
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) : ShoppingRepository {
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem = shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem = shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
        return try {
            val response = pixabayAPI.searchForImage(imageQuery)
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("unknown error", null)
            } else {
                Resource.error("unknown error", null)
            }
        } catch (e: Exception) {
            Resource.error("unknown error", null)
        }
    }
}
