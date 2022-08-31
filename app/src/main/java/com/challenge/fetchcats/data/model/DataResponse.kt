package com.challenge.fetchcats

data class DataResponse(
    val data: List<Data>
)

data class Data(
    val images: List<Image>?
)

data class Image(
    val link: String?
)