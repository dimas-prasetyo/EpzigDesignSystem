package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.epzigdesignsystem.databinding.ActivityInputPasswordBinding

class InputPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}