package com.sibela.coroutinescourse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        firstExampleButton.setOnClickListener(::onFirstExampleClicked)
    }

    private fun onFirstExampleClicked(view: View) {
        startActivity(Intent(this, BasicExampleActivity::class.java))
    }
}