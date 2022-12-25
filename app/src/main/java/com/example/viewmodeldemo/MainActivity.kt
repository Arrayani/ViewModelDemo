package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var count = 0
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //cara akses viewmodel, ini boiler plate, ikutin aja
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val displayNo = binding.tvCount
        val tombol = binding.button

        //displayNo.text = count.toString()
        //displayNo.text = viewModel.count.toString()

        viewModel.count.observe(this, Observer {
            displayNo.text = it.toString()
        }) //perhatikan ini mengakses variabel, bukanyya sebuah fungsi, ini yang akan di observasi

        tombol.setOnClickListener {
            //++count
            //displayNo.text = count.toString()
            viewModel.updateCount()
           // displayNo.text =  viewModel.count.toString()
        }

    }
}