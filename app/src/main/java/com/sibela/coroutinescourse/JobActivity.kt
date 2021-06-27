package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityJobBinding

class JobActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJobBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}