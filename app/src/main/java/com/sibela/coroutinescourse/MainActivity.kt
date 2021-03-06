package com.sibela.coroutinescourse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() = with(binding) {
        firstExampleButton.setOnClickListener(::onFirstExampleClicked)
        secondExampleButton.setOnClickListener(::onSecondExampleClicked)
        thirdExampleButton.setOnClickListener(::onThirdExampleClicked)
        fourthExampleButton.setOnClickListener(::onFourthExampleClicked)
        fifthExampleButton.setOnClickListener(::onFifthExampleClicked)
        sixthExampleButton.setOnClickListener(::onSixthExampleClicked)
        seventhExampleButton.setOnClickListener(::onSeventhExampleClicked)
        eighthExampleButton.setOnClickListener(::onEighthExampleClicked)
    }

    private fun onFirstExampleClicked(view: View) {
        startActivity(Intent(this, BasicExampleActivity::class.java))
    }

    private fun onSecondExampleClicked(view: View) {
        startActivity(Intent(this, AlteringContextActivity::class.java))
    }

    private fun onThirdExampleClicked(view: View) {
        startActivity(Intent(this, NetworkTimeoutActivity::class.java))
    }

    private fun onFourthExampleClicked(view: View) {
        startActivity(Intent(this, JobActivity::class.java))
    }

    private fun onFifthExampleClicked(view: View) {
        startActivity(Intent(this, ParallelJobsActivity::class.java))
    }

    private fun onSixthExampleClicked(view: View) {
        startActivity(Intent(this, AsyncAndAwaitActivity::class.java))
    }

    private fun onSeventhExampleClicked(view: View) {
        startActivity(Intent(this, SequentialJobsActivity::class.java))
    }

    private fun onEighthExampleClicked(view: View) {
        startActivity(Intent(this, RunBlockingActivity::class.java))
    }
}
