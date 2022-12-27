package com.example.datastoreapp.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.datastoreapp.R
import com.example.datastoreapp.databinding.ActivityInfoManagerBinding
import com.example.datastoreapp.storetype.SPStore
import com.example.datastoreapp.viewmodel.InfoManagerViewModel
import com.example.datastoreapp.viewmodel.MainViewModel.MainStates

class InfoManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInfoManagerBinding
    private lateinit var viewModel: InfoManagerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.extras?.get(STORE_TYPE)?.let {
            configView(it as MainStates)
        }
        viewModel = InfoManagerViewModel(SPStore(this))
    }

    private fun configView(storeType: MainStates) = with(binding) {
        when (storeType) {
            MainStates.GO_TO_SHARED_PREFERENCES_VIEW -> {
                tilName.visibility = View.VISIBLE
                btnSave.setOnClickListener {
                    viewModel.saveInfoPressed(tietName.text.toString())
                    tietName.text?.clear()
                }
                btnLoad.setOnClickListener { tvShowInfo.text = getString(R.string.txt_show_info, viewModel.loadInfoPressed()) }
            }
            MainStates.GO_TO_PROTO_DATASTORE_VIEW -> TODO()
            MainStates.GO_TO_PREFERENCES_DATASTORE_VIEW -> TODO()
        }
    }

    companion object {
        const val STORE_TYPE = "STORE_TYPE"
    }
}
