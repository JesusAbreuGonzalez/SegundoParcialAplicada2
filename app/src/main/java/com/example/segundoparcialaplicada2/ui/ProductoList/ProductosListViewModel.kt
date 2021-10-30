package com.example.segundoparcialaplicada2.ui.ProductoList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductosListViewModel(application: Application) : ViewModel() {

    class Factory(val app : Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom((ProductosListViewModel::class.java))){
                @Suppress("UNCHECKED_CAST")
                return ProductosListViewModel(app) as T
            }
            throw IllegalAccessException("Unable to construct viewModel")
        }
    }
}