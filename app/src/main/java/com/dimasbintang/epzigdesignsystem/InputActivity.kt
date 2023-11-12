package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.epzigdesignsystem.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.inputTextIcon.startIconIsClickable(false)

    }
}