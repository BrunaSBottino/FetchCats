package com.challenge.fetchcats.domain.application

import android.app.Application
import com.challenge.fetchcats.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class FetchCatsApplication : Application() {

    val viewModelModule = module {
        viewModel { MainViewModel() }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(viewModelModule)
        }
    }

}