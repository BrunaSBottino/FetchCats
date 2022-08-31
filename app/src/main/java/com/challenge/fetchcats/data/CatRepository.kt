package com.challenge.fetchcats.data

import android.util.Log
import com.challenge.fetchcats.DataResponse
import com.challenge.fetchcats.domain.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

class CatRepository {

    suspend fun getCatImageLinks(): DataResponse? =
        withContext(Dispatchers.IO) {

            val response = try {
                RetrofitInstance.api.fetchCats(RetrofitInstance.AUTHORIZATION_KEY)
            } catch (e: IOException) {
                Log.e("Teste", "msg = ${e.message}")
                null
            }
            return@withContext if (response?.isSuccessful == true) {
                response.body()
            } else {
                null
            }
        }
}