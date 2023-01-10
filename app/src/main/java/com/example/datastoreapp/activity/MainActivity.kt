package com.example.datastoreapp.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datastoreapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() = binding.btnGoToInfoManager.setOnClickListener {
        this@MainActivity.startActivity(InfoManagerActivity.getIntent(this@MainActivity))
    }

}
