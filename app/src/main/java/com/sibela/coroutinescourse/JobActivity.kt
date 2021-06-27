package com.sibela.coroutinescourse

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityJobBinding
import kotlinx.coroutines.*

class JobActivity : AppCompatActivity() {

    private companion object {
        const val PROGRESS_MAX = 100
        const val PROGRESS_START = 0
        const val JOB_TIME = 4_000 // ms
    }

    // A Completable job is a job that you can decide when it is completed
    private lateinit var job: CompletableJob
    private lateinit var binding: ActivityJobBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.jobButton.setOnClickListener {
            // if the job lat init variable is not initialized
            if (!::job.isInitialized) {
                initJob()
            }
            binding.jobProgressBar.startOrCancelJob(job)
        }
    }

    private fun initJob() = with(binding) {
        jobButton.text = "Start Job"
        updateJobCompleteTextView("")
        job = Job()

        // This methods is invoked whether the job is cancelled or completed
        job.invokeOnCompletion {
            it?.message.let {
                var message = it
                if (message.isNullOrBlank()) {
                    message = "Unknown cancellation error."
                }
                println("$job was cancelled. Reason: $message")
                showToast(message)
            }
        }
        jobProgressBar.max = PROGRESS_MAX
        jobProgressBar.progress = PROGRESS_START
    }

    private fun showToast(text: String) {
        GlobalScope.launch(Dispatchers.Main) {
            Toast.makeText(this@JobActivity, text, Toast.LENGTH_LONG).show()
        }
    }

    private fun ProgressBar.startOrCancelJob(job: Job) {
        if (progress > 0) {
            println("$job is already active. Cancelling...")
            resetJob()
        } else {
            binding.jobButton.text = "Cancel job"

            // Binding the coroutine scope to the job thus creating a brand new coroutine context
            // Now you can cancel the job the launch method returns
            CoroutineScope(Dispatchers.IO + job).launch {
                println("Coroutine $this is activated with job $job")
                for (i in PROGRESS_START..PROGRESS_MAX) {
                    delay((JOB_TIME / PROGRESS_MAX).toLong())
                    this@startOrCancelJob.progress = i
                }
                binding.jobCompleteText
                updateJobCompleteTextView("Job is completed")
            }
        }
    }

    private fun updateJobCompleteTextView(text: String) {
        GlobalScope.launch(Dispatchers.Main) {
            binding.jobCompleteText.text = text
        }
    }

    private fun resetJob() {
        if (job.isActive || job.isCompleted) {
            job.cancel(CancellationException("Resetting job"))
        }
        initJob()
    }
}