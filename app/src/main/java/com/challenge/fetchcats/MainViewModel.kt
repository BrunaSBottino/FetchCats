package com.challenge.fetchcats

import android.util.Log
import androidx.lifecycle.ViewModel
import com.challenge.fetchcats.network.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel : ViewModel() {

    fun getCatImageLinks(onSuccess: (List<String>) -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {

            val response = try {
                RetrofitInstance.api.fetchCats(RetrofitInstance.AUTHORIZATION_KEY)
            } catch (e: IOException) {
                Log.e("Teste", "msg = ${e.message}")
                null
            }

            if (response?.isSuccessful == true){
                val data = response.body()?.data
                val imageList = arrayListOf<Image>()
                val links = arrayListOf<String>()
                data?.forEach {
                    imageList.addAll(it.images)
                }
                imageList.forEach {
                    links.add(it.link)
                }
                onSuccess(links)
            }
        }
    }
}
