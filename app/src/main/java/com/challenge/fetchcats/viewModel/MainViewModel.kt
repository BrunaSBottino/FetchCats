package com.challenge.fetchcats.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.fetchcats.data.CatRepository
import com.challenge.fetchcats.domain.usecase.CatLinkFilterUsecase
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: CatRepository = CatRepository(),
    private val usecase: CatLinkFilterUsecase = CatLinkFilterUsecase(),
) : ViewModel() {

    private val imageLinks_ = MutableLiveData<ArrayList<String>>(arrayListOf())
    val imageLinks : LiveData<ArrayList<String>>
        get() = imageLinks_

    fun getCatImageLinks() {
        viewModelScope.launch{
            val dataResponse = repository.getCatImageLinks()
            dataResponse?.let {
                imageLinks_.value = usecase.getLinks(it)
            }
        }
    }
}
