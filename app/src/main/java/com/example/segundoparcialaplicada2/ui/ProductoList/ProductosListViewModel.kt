package com.example.segundoparcialaplicada2.ui.ProductoList

import android.app.Application
import androidx.lifecycle.*
import com.example.segundoparcialaplicada2.api.Producto
import com.example.segundoparcialaplicada2.api.RetrofitInstance
import kotlinx.coroutines.launch

class ProductosListViewModel(application: Application) : ViewModel() {

    private val _lista = MutableLiveData<List<Producto>>()
    val lista: LiveData<List<Producto>> get() = _lista

    init{
        viewModelScope.launch {
            _lista.value = RetrofitInstance.api.getProducto()
        }
    }

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