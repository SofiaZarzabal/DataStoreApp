package com.example.datastoreapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.datastoreapp.R
import com.example.datastoreapp.databinding.FragmentPreferencesDataStoreBinding

class PreferencesDataStoreFragment : Fragment(R.layout.fragment_preferences_data_store) {
    private lateinit var binding: FragmentPreferencesDataStoreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPreferencesDataStoreBinding.inflate(layoutInflater)
        return binding.root
    }
}
