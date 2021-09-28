package com.sitapuramargram.pinkdelivery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sitapuramargram.pinkdelivery.R
import com.sitapuramargram.pinkdelivery.adapters.ViewPagerAdapter
import com.sitapuramargram.pinkdelivery.databinding.ActivityMainBinding
import com.sitapuramargram.pinkdelivery.model.Data
import com.sitapuramargram.pinkdelivery.repositories.ApiResponse
import com.sitapuramargram.pinkdelivery.repositories.ItemRepository
import com.sitapuramargram.pinkdelivery.viewmodel.MainViewModel
import com.sitapuramargram.pinkdelivery.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var activityMainBinding: ActivityMainBinding
    var dataList: List<Data> = ArrayList<Data>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= ActivityMainBinding.inflate(layoutInflater)
        val view: View = activityMainBinding.root
        setContentView(view)

        var toolbar = activityMainBinding.toolbar
        var viewPager = activityMainBinding.viewPager
        var tabLayout = activityMainBinding.tabLayout
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)




        val itemRepository = ItemRepository(this)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(itemRepository)).get(MainViewModel::class.java)

        mainViewModel.dataList.observe(this,{
           when(it){
               is ApiResponse.Loading -> {
                   Log.d("TAG", "Loading")
               }
               is ApiResponse.Success -> {
                   it.data?.let {
                       Log.d("TAG", "Success: $it")
                       dataList = it

                       setUpViewPager(viewPager,it)
                       TabLayoutMediator(tabLayout,viewPager){
                           tab,position ->
                               tab.text= it[position].catName
                       }.attach()
                   }

               }
               is ApiResponse.Error -> {
                   Log.d("TAG","Error: ${it.errorMessage}")
                   Toast.makeText(this,"Error: ${it.errorMessage}",Toast.LENGTH_LONG).show()
               }
           }
        })



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.notification_menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            android.R.id.home -> super.onBackPressed()
            R.id.notification -> Toast.makeText(this,"Notification menu clicked!",Toast.LENGTH_LONG).show()

        }

        return super.onOptionsItemSelected(item)
    }

    private fun setUpViewPager(viewPager: ViewPager2, dataList:List<Data>){

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle,dataList)
        viewPager.adapter = pagerAdapter



    }
}