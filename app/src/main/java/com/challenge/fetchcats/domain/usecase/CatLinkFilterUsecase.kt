package com.challenge.fetchcats.domain.usecase

import com.challenge.fetchcats.DataResponse
import com.challenge.fetchcats.Image

class CatLinkFilterUsecase {

    fun getLinks(dataResponse: DataResponse): ArrayList<String> {

        val imageList = arrayListOf<Image>()
        val links = arrayListOf<String>()
        dataResponse.data.forEach {
            imageList.addAll(it.images ?: listOf())
        }
        imageList.forEach {
            it.link?.let {
                links.add(it)
            }
        }
        return links
    }
}
