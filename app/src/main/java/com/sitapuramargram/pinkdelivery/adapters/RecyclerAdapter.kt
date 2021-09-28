package com.sitapuramargram.pinkdelivery.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sitapuramargram.pinkdelivery.R
import com.sitapuramargram.pinkdelivery.databinding.RecyclerItemViewBinding
import com.sitapuramargram.pinkdelivery.model.Items

class RecyclerAdapter(private val context: Context, private val itemList: List<Items>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder (val binding: RecyclerItemViewBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       with(holder){
           with(itemList[position]){
               binding.itemName.text =this.productName
               binding.itemCatName.text = this.categoryName
               binding.itemPrice.text = "$${this.price}"
                Glide.with(context)
                        .load(this.productImage)
                        .into(binding.itemImage)
               binding.favourite.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.ic_baseline_favorite_border_24))


           }

       }
    }

    override fun getItemCount(): Int {
        return  itemList.size
    }
}