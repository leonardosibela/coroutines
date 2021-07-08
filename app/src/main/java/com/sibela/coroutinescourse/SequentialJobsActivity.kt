package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivitySequentialJobsBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class SequentialJobsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySequentialJobsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySequentialJobsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickMeButton.setOnClickListener { fakeApiRequests() }
    }

    private fun fakeApiRequests() = CoroutineScope(Dispatchers.IO).launch {
        val executionTime = measureTimeMillis {
            val userName: String = getUserName()
            val greet: String = getGreet(userName)
            setTextOnMainThread(greet)
        }

        println("debug: total elapsed time: $executionTime")
    }

    private suspend fun setTextOnMainThread(text: String) = withContext(Dispatchers.Main) {
        binding.textInput.text = text
    }

    private suspend fun getUserName(): String {
        delay(1_000)
        return "Leonardo"
    }

    private suspend fun getGreet(userName: String): String {
        delay(1_700)
        return "Hello $userName"
    }
}