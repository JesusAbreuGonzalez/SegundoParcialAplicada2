package com.example.segundoparcialaplicada2.api

//Clase solamente para prueba
data class Producto(
    val millas: Int,
    val observaciones: String,
    val travelId: Int
)

//Esta es la verdadera clase pero no puedo usar esos datos porque mi cuenta de azure no me permite usar el appService
/*data class Producto (
    val productoId: Int,
    val decripcion: String,
    val existencia: Float,
    val costo: Float,
    val valorInventario: Float
)*/