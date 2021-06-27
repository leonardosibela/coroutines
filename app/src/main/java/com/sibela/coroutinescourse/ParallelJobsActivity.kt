package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityParallelJobsBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class ParallelJobsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParallelJobsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParallelJobsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.clickMeButton.setOnClickListener { fakeApiRequests() }
    }

    private fun fakeApiRequests() {
        val startTime = System.currentTimeMillis()
        val parentJob = CoroutineScope(Dispatchers.IO).launch {
            val jobOne = launch {
                val timeJobOne = measureTimeMillis {
                    println("debug: launch jobOne in thread: ${Thread.currentThread().name}")
                    val resultOne = getResultFromAPIOne()
                    setTextOnMainThread(resultOne)
                }
                println("debug: completed jobOne in $timeJobOne ms.")
            }
            val jobTwo = launch {
                val timeJobTwo = measureTimeMillis {
                    println("debug: launch jobTwo in thread: ${Thread.currentThread().name}")
                    val resultTwo = getResultFromAPITwo()
                    setTextOnMainThread(resultTwo)
                }
                println("debug: completed jobTwo in $timeJobTwo ms.")
            }
        }

        // Here you will be able to see that both jobs started in parallel once the total time it took
        // to execute both jobs are roughly 1700 ms (which is the time it take for job 2 to complete)
        parentJob.invokeOnCompletion {
            println("debug: total elapsed time ${System.currentTimeMillis() - startTime}")
        }
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