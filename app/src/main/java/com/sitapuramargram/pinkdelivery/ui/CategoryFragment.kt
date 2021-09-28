package com.sitapuramargram.pinkdelivery.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sitapuramargram.pinkdelivery.R
import com.sitapuramargram.pinkdelivery.adapters.RecyclerAdapter
import com.sitapuramargram.pinkdelivery.databinding.FragmentCategoryBinding
import com.sitapuramargram.pinkdelivery.model.Items


class CategoryFragment(var itemList: List<Items>) : Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
            var binding = FragmentCategoryBinding.inflate(inflater,container,false)

        var adapter = context?.let { RecyclerAdapter(it,itemList) }
        var layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


        return binding.root
    }


}