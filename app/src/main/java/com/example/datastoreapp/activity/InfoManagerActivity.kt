package com.example.datastoreapp.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.datastoreapp.R
import com.example.datastoreapp.adapter.ViewPagerAdapter
import com.example.datastoreapp.databinding.ActivityInfoManagerBinding
import com.example.datastoreapp.fragment.PreferencesDataStoreFragment
import com.example.datastoreapp.fragment.ProtoDataStoreFragment
import com.example.datastoreapp.fragment.SharedPreferencesFragment
import com.example.datastoreapp.utils.setupWithViewPager2

class InfoManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoManagerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configTabs()
    }

    private fun configTabs() = with(binding) {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(SharedPreferencesFragment(), getString(R.string.txt_shared_preferences_title))
        viewPagerAdapter.addFragment(PreferencesDataStoreFragment(), getString(R.string.txt_preferences_data_store_title))
        viewPagerAdapter.addFragment(ProtoDataStoreFragment(), getString(R.string.txt_proto_data_store_title))
        viewPagerStorageTypes.adapter = viewPagerAdapter
        tabLayoutStorageTypes.setupWithViewPager2(viewPagerStorageTypes)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, InfoManagerActivity::class.java)
    }
}
