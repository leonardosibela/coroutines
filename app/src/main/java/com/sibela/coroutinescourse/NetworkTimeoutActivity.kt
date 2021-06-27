package com.sibela.coroutinescourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityNetworkTimeoutBinding

class NetworkTimeoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNetworkTimeoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkTimeoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getResultButton.setOnClickListener(::onGetResultClicked)
    }

    private fun onGetResultClicked(view: View) {
        
    }
}