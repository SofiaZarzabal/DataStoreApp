package com.example.datastoreapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datastoreapp.activity.InfoManagerActivity.Companion.STORE_TYPE
import com.example.datastoreapp.databinding.ActivityMainBinding
import com.example.datastoreapp.viewmodel.MainViewModel
import com.example.datastoreapp.viewmodel.MainViewModel.MainData
import com.example.datastoreapp.viewmodel.StoreType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = MainViewModel()
        viewModel.getValue().observe({ lifecycle }, ::updateUI)
        setListeners()
    }

    private fun updateUI(data: MainData) {
        this.startActivity(Intent(this, InfoManagerActivity::class.java).apply {
            putExtra(STORE_TYPE, data.state)
        })
    }

    private fun setListeners() = with(binding) {
        btnSp.setOnClickListener { viewModel.onButtonPressed(StoreType.SHARED_PREFERENCES) }
        btnPds.setOnClickListener { viewModel.onButtonPressed(StoreType.PREFERENCES_DATASTORE) }
        btnPrds.setOnClickListener { viewModel.onButtonPressed(StoreType.PROTO_DATASTORE) }
    }
}
