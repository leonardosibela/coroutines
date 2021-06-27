package com.sibela.coroutinescourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityNetworkTimeoutBinding
import kotlinx.coroutines.*

class NetworkTimeoutActivity : AppCompatActivity() {

    private companion object {
        const val TIMEOUT = 1_000L
    }

    private lateinit var binding: ActivityNetworkTimeoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNetworkTimeoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.getResultButton.setOnClickListener(::onGetResultClicked)
    }

    private fun onGetResultClicked(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = withTimeoutOrNull(TIMEOUT) { getResult() }
            if (result == null) {
                displayTextOnMainThread("getResult timed out")
            } else {
                displayTextOnMainThread(result)
            }
        }
    }

    private suspend fun displayTextOnMainThread(text: String) = withContext(Dispatchers.Main) {
        binding.resultText.text = text
    }

    private suspend fun getResult(): String {
        delay(2_000)
        return "Some result"
    }
}