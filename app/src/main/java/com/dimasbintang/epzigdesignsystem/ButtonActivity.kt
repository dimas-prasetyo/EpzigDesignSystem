package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.epzigdesignsystem.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}