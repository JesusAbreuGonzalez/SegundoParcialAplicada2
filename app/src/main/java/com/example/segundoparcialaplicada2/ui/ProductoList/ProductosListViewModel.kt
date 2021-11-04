package com.example.segundoparcialaplicada2.ui.ProductoList

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.segundoparcialaplicada2.api.Producto
import com.example.segundoparcialaplicada2.api.RetrofitInstance
import kotlinx.coroutines.launch

enum class ApiStatus{LOADING, ERROR, DONE}

class ProductosListViewModel(application: Application) : ViewModel() {

    private val _lista = MutableLiveData<List<Producto>>()
    val lista: LiveData<List<Producto>> get() = _lista

    private val _mensajeError = MutableLiveData<String>()
    val mensajeError: LiveData<String> get() = _mensajeError

    private val _cargando = MutableLiveData<Boolean>()
    val cargando: LiveData<Boolean> get() = _cargando

    private val _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> get() = _status

    init{
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try{
                _cargando.value = true
                _lista.value = RetrofitInstance.api.getProducto()
                _status.value = ApiStatus.DONE
            }catch (e: Exception)
            {
                Log.e("ProductosListViewModel", "Fallo al buscar los datos api ${e.message}")

                _mensajeError.value = "Fallo ${e.message}"
                _status.value = ApiStatus.ERROR
                _lista.value = ArrayList()
            }
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