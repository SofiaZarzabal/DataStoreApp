package com.example.datastoreapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.datastoreapp.R
import com.example.datastoreapp.databinding.FragmentProtoDataStoreBinding

class ProtoDataStoreFragment : Fragment(R.layout.fragment_proto_data_store) {
    private lateinit var binding: FragmentProtoDataStoreBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentProtoDataStoreBinding.inflate(layoutInflater)
        return binding.root
    }
}
