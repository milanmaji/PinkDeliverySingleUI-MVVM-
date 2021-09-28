package com.sitapuramargram.pinkdelivery.model

import com.google.gson.annotations.SerializedName

data class Items (

    @SerializedName("product_id") var productId : String,
    @SerializedName("product_suk_id") var productSukId : String,
    @SerializedName("product_name") var productName : String,
    @SerializedName("category_id") var categoryId : String,
    @SerializedName("description") var description : String,
    @SerializedName("product_image") var productImage : String,
    @SerializedName("price") var price : String,
    @SerializedName("vendor_id") var vendorId : String,
    @SerializedName("status") var status : String,
    @SerializedName("created_at") var createdAt : String,
    @SerializedName("updated_at") var updatedAt : String,
    @SerializedName("category_name") var categoryName : String,
    @SerializedName("vendor_name") var vendorName : String
)