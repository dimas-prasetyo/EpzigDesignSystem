package com.dimasbintang.design_system.snackbar

import android.app.Activity
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.SnackbarActionViewBinding
import com.dimasbintang.design_system.databinding.SnackbarSimpleViewBinding
import com.google.android.material.snackbar.Snackbar

object CustomSnackbar {
    fun showSimpleSnackbar(activity: Activity, message: String, icon: Drawable? = null, duration: Int = Snackbar.LENGTH_SHORT) {
        val inflater = LayoutInflater.from(activity)
        val binding = SnackbarSimpleViewBinding.inflate(inflater)

        binding.text.text = message
        binding.icon.isVisible = icon != null
        binding.icon.setImageDrawable(icon)

        createSnackbar(activity, binding.root, duration)
    }

    fun showSuccessSnackbar(activity: Activity, message: String = "", duration: Int = Snackbar.LENGTH_SHORT) {
        val inflater = LayoutInflater.from(activity)
        val binding = SnackbarSimpleViewBinding.inflate(inflater)

        binding.text.text = message.takeIf { it.isNotBlank() } ?: "Success"
        val icon = ContextCompat.getDrawable(activity.baseContext, R.drawable.bxs_check_circle)
        binding.icon.setImageDrawable(icon)
        val iconTint = ColorStateList.valueOf(ContextCompat.getColor(activity.baseContext, R.color.teal_600))
        binding.icon.imageTintList = iconTint

        createSnackbar(activity, binding.root, duration)
    }

    fun showErrorSnackbar(activity: Activity, message: String = "", duration: Int = Snackbar.LENGTH_SHORT) {
        val inflater = LayoutInflater.from(activity)
        val binding = SnackbarSimpleViewBinding.inflate(inflater)

        binding.text.text = message.takeIf { it.isNotBlank() } ?: "Error"
        val icon = ContextCompat.getDrawable(activity.baseContext, R.drawable.bxs_x_circle)
        binding.icon.setImageDrawable(icon)
        val iconTint = ColorStateList.valueOf(ContextCompat.getColor(activity.baseContext, R.color.rose_600))
        binding.icon.imageTintList = iconTint

        createSnackbar(activity, binding.root, duration)
    }
    fun showSnackbarAction(activity: Activity, message: String, actionText: String, icon: Drawable? = null, duration: Int = Snackbar.LENGTH_LONG,  actionListener: () -> Unit) {
        val inflater = LayoutInflater.from(activity)
        val binding = SnackbarActionViewBinding.inflate(inflater)

        binding.text.text = message
        binding.icon.isVisible = icon != null
        binding.icon.setImageDrawable(icon)

        val snackbar = createSnackbar(activity, binding.root, duration)

        binding.button.text = actionText
        binding.button.setOnClickListener {
            snackbar.dismiss()
            actionListener()
        }
    }

    private fun createSnackbar(activity: Activity, view: View, duration: Int): Snackbar {
        val rootView = activity.window.decorView.rootView

        val snackbar = Snackbar.make(rootView, "", duration)
        val snackbarView = snackbar.view as Snackbar.SnackbarLayout

        snackbarView.removeAllViews()
        snackbarView.addView(view, 0)
        snackbarView.setPadding(0, 0, 0, 20)
        snackbarView.setBackgroundColor(Color.TRANSPARENT)

        snackbar.show()
        return snackbar
    }
}