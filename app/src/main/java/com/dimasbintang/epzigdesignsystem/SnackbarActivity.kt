package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.dimasbintang.design_system.snackbar.CustomSnackbar.showErrorSnackbar
import com.dimasbintang.design_system.snackbar.CustomSnackbar.showSimpleSnackbar
import com.dimasbintang.design_system.snackbar.CustomSnackbar.showSnackbarAction
import com.dimasbintang.design_system.snackbar.CustomSnackbar.showSuccessSnackbar
import com.dimasbintang.epzigdesignsystem.databinding.ActivitySnackbarBinding
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySnackbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySnackbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.successSnackbar.setOnClickListener {
            //showSuccessSnackbar(this)
            //showSuccessSnackbar(this, "Success")
            showSuccessSnackbar(this, "Success", Snackbar.LENGTH_SHORT)
        }

        binding.errorSnackbar.setOnClickListener {
            showErrorSnackbar(this, "Error")
        }

        binding.simpleSnackbar.setOnClickListener {
            val icon = ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_alarm)
            showSimpleSnackbar(this, "Alarm", icon)
        }

        binding.actionSnackbar.setOnClickListener {
            showSnackbarAction(this, "Do some Action", "Action") {
                // action
                Toast.makeText(this, "Action from snackbar", Toast.LENGTH_SHORT).show()
            }
        }
    }
}