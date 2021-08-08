package com.sibela.coroutinescourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityRunBlockingBinding
import kotlinx.coroutines.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class RunBlockingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRunBlockingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRunBlockingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.clickMeButton.setOnClickListener { runCoroutines() }
    }

    private fun runCoroutines() {
        // Runs a new coroutines and blocks the current thread interruptibly
        // The display of the texts will be delayed for 3 seconds
        runBlocking(Dispatchers.IO) {
            delay(3_000)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val firstRandomNumber = getRandomNumber()
            setTextOnMainThread(firstRandomNumber)

            val secondRandomNumber = getRandomNumber()
            setTextOnMainThread(secondRandomNumber)

            val thirdRandomNumber = getRandomNumber()
            setTextOnMainThread(thirdRandomNumber)
        }
    }

    private suspend fun setTextOnMainThread(text: String) = withContext(Dispatchers.Main) {
        binding.textInput.text = text
    }

    private suspend fun getRandomNumber(): String {
        delay(1_000)
        return Random.nextInt(0, 100).toString()
    }
}