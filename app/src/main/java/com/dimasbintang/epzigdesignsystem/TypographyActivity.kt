package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.epzigdesignsystem.databinding.ActivityTypographyBinding

class TypographyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTypographyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTypographyBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}