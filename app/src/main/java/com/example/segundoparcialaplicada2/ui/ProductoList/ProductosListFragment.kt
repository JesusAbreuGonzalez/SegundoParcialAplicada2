package com.example.segundoparcialaplicada2.ui.ProductoList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.segundoparcialaplicada2.R
import com.example.segundoparcialaplicada2.adapters.ProductoAdapter
import com.example.segundoparcialaplicada2.api.Producto
import com.example.segundoparcialaplicada2.api.RetrofitInstance
import com.example.segundoparcialaplicada2.databinding.ProductoRowBinding
import com.example.segundoparcialaplicada2.databinding.ProductosListFragmentBinding
import com.google.android.material.snackbar.Snackbar

class ProductosListFragment : Fragment() {

    private var _binding: ProductosListFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ProductosListFragment()
    }

    private lateinit var viewModel: ProductosListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProductosListFragmentBinding.inflate(layoutInflater)
        viewModel =
            ViewModelProvider(this, ProductosListViewModel.Factory(requireActivity().application))
                .get(ProductosListViewModel::class.java)

        viewModel.lista.observe(viewLifecycleOwner, Observer {
            val adapter = ProductoAdapter()
            adapter.submitList(it)
            binding.productosRecycleView.adapter = adapter
        })

        /*viewModel.mensajeError.observe(this, Observer {
            Snackbar.make(binding.productosRecycleView, "$mensajeError", Snackbar.LENGTH_LONG).show()
        })*/

        viewModel.status.observe(viewLifecycleOwner, Observer {
            binding.progressBar.isVisible = (it == ApiStatus.LOADING)
        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProductosListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}