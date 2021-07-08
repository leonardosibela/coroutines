package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityAsyncAndAwaitBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class AsyncAndAwaitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAsyncAndAwaitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAsyncAndAwaitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickMeButton.setOnClickListener { fakeApiRequests() }
    }

    private fun fakeApiRequests() = CoroutineScope(Dispatchers.IO).launch {
        val executionTime = measureTimeMillis {
            val resultOne: Deferred<String> = async {
                println("debug: launching job1: ${Thread.currentThread().name}")
                getResultFromAPIOne()
            }
            val resultTwo: Deferred<String> = async {
                println("debug: launching job2: ${Thread.currentThread().name}")
                getResultFromAPITwo()
            }
            setTextOnMainThread("Got ${resultOne.await()}")
            setTextOnMainThread("Got ${resultTwo.await()}")
        }
        println("debug: total elapsed time: $executionTime")
    }

    private suspend fun setTextOnMainThread(text: String) = withContext(Dispatchers.Main) {
        val newText = "${binding.messageText.text}\n$text"
        binding.messageText.text = newText
    }

    private suspend fun getResultFromAPIOne(): String {
        delay(1_000)
        return "result one"
    }

    private suspend fun getResultFromAPITwo(): String {
        delay(1_700)
        return "result one"
    }
}