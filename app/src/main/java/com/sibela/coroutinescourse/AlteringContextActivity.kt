package com.sibela.coroutinescourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sibela.coroutinescourse.databinding.ActivityAlteringContextBinding

class AlteringContextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlteringContextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlteringContextBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}