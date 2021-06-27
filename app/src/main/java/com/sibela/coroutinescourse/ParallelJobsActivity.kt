package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityParallelJobsBinding

class ParallelJobsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParallelJobsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParallelJobsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}