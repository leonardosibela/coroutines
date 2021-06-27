package com.sibela.coroutinescourse

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityAlteringContextBinding
import kotlinx.coroutines.*

class AlteringContextActivity : AppCompatActivity() {

    private var count = 0

    private lateinit var binding: ActivityAlteringContextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlteringContextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() = with(binding) {
        displayTextButton.setOnClickListener(::onDisplayTextClicked)
    }

    private fun onDisplayTextClicked(view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = getResult()
            displayTextOnMainThread(result)
        }
    }

    // withContext is a method that alters the context of a coroutine thus altering it's job thread
    private suspend fun displayTextOnMainThread(result: String) = withContext(Dispatchers.Main) {
        val newText = "${binding.textView.text}\n$result"
        binding.textView.text = newText
    }

    private suspend fun getResult(): String {
        delay(1_000)
        return "Result ${++count}"
    }
}