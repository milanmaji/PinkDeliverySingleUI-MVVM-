package com.sitapuramargram.pinkdelivery.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("cat_id") var catId : String,
    @SerializedName("cat_name") var catName : String,
    @SerializedName("items") var items : List<Items>
)