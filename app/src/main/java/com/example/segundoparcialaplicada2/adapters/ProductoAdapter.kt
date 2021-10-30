package com.example.segundoparcialaplicada2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.segundoparcialaplicada2.api.Producto
import com.example.segundoparcialaplicada2.databinding.ProductoRowBinding

class ProductoAdapter : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {
    private var productos = emptyList<Producto>()

    fun submitList(lista: List<Producto>){
        productos = lista
        notifyDataSetChanged()
    }

    inner class ProductoViewHolder(val binding: ProductoRowBinding) :
            RecyclerView.ViewHolder(binding.root){

        fun bind(producto: Producto){

            //VERDADERO BIND, no puedo usar estos campos por lo de mi cuenta de azure

            /*binding.productoIdTextView.text = producto.productoId.toString()
            binding.descripcionTextView.text = producto.descripcion
            binding.existenciaTextView.text = producto.existencia.toString()
            binding.costoTextView.text = producto.costo.toString()
            binding.valorInventarioTextView.text = producto.valorInventario.toString()*/

            binding.productoIdTextView.text = producto.travelId.toString()
            binding.descripcionTextView.text = producto.observaciones
            binding.existenciaTextView.text = "0"
            binding.costoTextView.text = producto.millas.toString()
            binding.valorInventarioTextView.text = "0"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ProductoRowBinding.inflate(inflater, parent, false)

        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]

        holder.bind(producto)
    }

    override fun getItemCount(): Int {
        return productos.size
    }


}