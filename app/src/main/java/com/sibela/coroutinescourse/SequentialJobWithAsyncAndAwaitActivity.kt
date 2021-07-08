package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivitySequentialJobWithAsyncAndAwaitBinding

class SequentialJobWithAsyncAndAwaitActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySequentialJobWithAsyncAndAwaitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySequentialJobWithAsyncAndAwaitBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}