package com.dimasbintang.epzigdesignsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.epzigdesignsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.btnToInputField.setOnClickListener {
            val intent = Intent(this, InputActivity::class.java)
            startActivity(intent)
        }
        binding.btnToInputPassword.setOnClickListener {
            val intent = Intent(this, InputPasswordActivity::class.java)
            startActivity(intent)
        }
        binding.btnToInputDropdown.setOnClickListener {
            val intent = Intent(this, InputChooseActivity::class.java)
            startActivity(intent)
        }
        binding.btnToButton.setOnClickListener {
            val intent = Intent(this, ButtonActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSegmentedButton.setOnClickListener {
            val intent = Intent(this, SegmentedButtonActivity::class.java)
            startActivity(intent)
        }
        binding.btnToSnackbar.setOnClickListener {
            val intent = Intent(this, SnackbarActivity::class.java)
            startActivity(intent)
        }
        binding.btnToDialog.setOnClickListener {
            val intent = Intent(this, DialogBottomSheetActivity::class.java)
            startActivity(intent)
        }
    }
}