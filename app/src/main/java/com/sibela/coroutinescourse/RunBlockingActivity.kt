package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityRunBlockingBinding

class RunBlockingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRunBlockingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRunBlockingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}