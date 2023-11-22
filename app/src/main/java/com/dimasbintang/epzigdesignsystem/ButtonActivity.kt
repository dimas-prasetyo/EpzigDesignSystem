package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dimasbintang.design_system.dialog.DialogConfirmation
import com.dimasbintang.design_system.snackbar.CustomSnackbar.showSuccessSnackbar
import com.dimasbintang.epzigdesignsystem.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityButtonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.primaryButton.setOnClickListener {
            val icon = ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_alarm)
            //showSimpleSnackbar(this, "Alarm set", icon)
            showSuccessSnackbar(this)
        }

        binding.primaryIconButton.setOnClickListener {
            /*showSnackbarAction(this, "TEs", "Pilih") {
                showErrorSnackbar(this)
            }*/
            val dialog = DialogConfirmation("Tes Title", "Ini message")
            dialog.show(supportFragmentManager, null)
            dialog.positiveListener = {

            }
            dialog.negativeListener = {
                dialog.dismiss()
            }
        }
    }
}