package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityBasicExampleBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BasicExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBasicExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBasicExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Starts a coroutine in a Coroutine Scope with the IO dispatcher/context.
        // There are 3 kinds of contexts:
        // IO: Used to read data, whether in a HTTP request or a local database
        // Main: To execute work on the Main Thread
        // Default: for heavy computational jobs
        CoroutineScope(Dispatchers.IO).launch {
            // It will first get the name from the getName method no matter how delayed it is
            val name = getName()

            // So you can call another suspend function and pass the value you got from the first
            val greet = getGreet(name)

            print(greet)
        }
    }

    // A suspending function is simply a function that can be paused and resumed at a later time.
    // They can execute a long running operation and wait for it to complete without blocking.
    private suspend fun getName(): String {
        // Delay the current coroutine
        // It is different from Thread.sleep() which delay the thread itself alongside with all
        // coroutines running on that thread. You should always use delay method on coroutines.
        delay(1_000)
        return "Leonardo"
    }

    private suspend fun getGreet(name: String): String {
        delay(1_000)
        return "Hello $name"
    }
}