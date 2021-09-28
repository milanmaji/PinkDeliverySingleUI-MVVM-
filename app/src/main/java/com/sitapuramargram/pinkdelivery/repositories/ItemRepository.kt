package com.sitapuramargram.pinkdelivery.repositories

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.sitapuramargram.pinkdelivery.model.Data
import org.json.JSONObject

class ItemRepository(val context: Context) {


    private val dataLiveData = MutableLiveData<ApiResponse<List<Data>>>()

    val dataList : LiveData<ApiResponse<List<Data>>>
    get() = dataLiveData


    suspend fun getProductData(storeId: String, userId: String,accessType: String,source: String){



        //start loading
        dataLiveData.postValue(ApiResponse.Loading())


        val url = "https://devfitser.com/PinkDelivery/dev/api/product/get"
        val obj  = JSONObject()
        obj.put("store_id",storeId)
        obj.put("user_id",userId)
        obj.put("access_type",accessType)
        obj.put("source",source)


        val requestQueue = Volley.newRequestQueue(context)

        val jsonObjectRequest = JsonObjectRequest(Request.Method.POST,url, obj, {

            Log.d("TAG",it.toString())

            if(it !=null) {
                var resObj = it.getJSONObject("result")
                var dataArray = resObj.getJSONArray("data")
                if(dataArray!=null){
                    var listData = ArrayList<Data>()
                    for(i in 0 until dataArray.length()){
                       var data = Gson().fromJson(dataArray.getJSONObject(i).toString(),Data::class.java)
                        listData.add(data)
                    }
                    dataLiveData.postValue(ApiResponse.Success(listData))
                }
            }


        }, {
            error ->

                Log.d("TAG", error.message.toString())
                dataLiveData.postValue(ApiResponse.Error(error.message.toString()))


        })
        requestQueue.add(jsonObjectRequest)

    }


}