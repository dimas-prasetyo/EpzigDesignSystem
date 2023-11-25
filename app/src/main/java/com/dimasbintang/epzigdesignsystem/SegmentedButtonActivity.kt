package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.epzigdesignsystem.databinding.ActivitySegmentedButtonBinding

class SegmentedButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySegmentedButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySegmentedButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}