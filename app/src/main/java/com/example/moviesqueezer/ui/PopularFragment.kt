package com.example.moviesqueezer.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.moviesqueezer.R
import com.example.moviesqueezer.viewModel.SharedViewModel

class PopularFragment : Fragment() {

    companion object {
        fun newInstance() = PopularFragment()
    }

    private lateinit var viewModel: SharedViewModel
    private lateinit var gridLayoutManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.popular_fragment, container, false)
        var popularRv = view.findViewById<RecyclerView>(R.id.popular_rv)
        popularRv.apply { layoutManager = GridLayoutManager(context, 2) }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(SharedViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModel.selected.observe(this, Observer<String> {
            // Update
        })


    }



}
