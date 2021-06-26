package com.sibela.coroutinescourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sibela.coroutinescourse.databinding.ActivityBasicExampleBinding

class BasicExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBasicExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}