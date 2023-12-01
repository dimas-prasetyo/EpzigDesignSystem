package com.dimasbintang.design_system.inputText

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.InputTextIconViewBinding
import com.google.android.material.textfield.TextInputEditText

@SuppressLint("ResourceType")
class InputTextIcon @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private val binding: InputTextIconViewBinding
    var startIconOnClick: () -> Unit = {}
    var endIconOnClick: () -> Unit = {}
    var editText: TextInputEditText


    var text: String
        get() = binding.input.text.toString()
        set(value) = binding.input.setText(value)

    init {
        val inflater = LayoutInflater.from(context)
        binding = InputTextIconViewBinding.inflate(inflater, this)
        editText = binding.input

        val set = intArrayOf(
            R.attr.title,
            android.R.attr.text,
            R.attr.hint,
            android.R.attr.drawableStart,
            android.R.attr.drawableEnd,
            android.R.attr.drawableTint,
            R.attr.iconClickable,
            android.R.attr.enabled,
        )

        val a = context.obtainStyledAttributes(attrs, set)
        val title = a.getText(0) ?: ""
        val text = a.getText(1) ?: ""
        val hint = a.getText(2) ?: ""
        val startIcon = a.getDrawable(3)
        val endIcon = a.getDrawable(4)
        val iconTint = a.getResourceId(5, 0)
        val isIconClickable = a.getBoolean(6, true)
        val isEnabled = a.getBoolean(7, true)

        binding.title.isVisible = title.isNotBlank()
        binding.title.text  = title
        binding.input.hint = if (hint.isNotBlank()) hint else if (title.isNotBlank()) title else ""
        binding.startIcon.isVisible = startIcon != null
        binding.endIcon.isVisible = endIcon != null

        binding.startIcon.setImageDrawable(startIcon)
        binding.endIcon.setImageDrawable(endIcon)
        if (iconTint != 0) {
            binding.startIcon.setColorFilter(ContextCompat.getColor(context, iconTint))
            binding.endIcon.setColorFilter(ContextCompat.getColor(context, iconTint))
        }
        if (startIcon == null) {
            val paddingHorizontal = resources.getDimensionPixelSize(R.dimen.spacing_semi_medium)
            val paddingVertical = resources.getDimensionPixelSize(R.dimen.spacing_input_medium)
            binding.input.setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
        }
        binding.startIcon.isClickable = isIconClickable
        binding.endIcon.isClickable = isIconClickable
        this.text = text.toString()

        setupFocusListener()
        setupOnClickListener()
        a.recycle()
    }

    private fun setupViewFocusStatus(hasFocus: Boolean) {
        if (hasFocus) {
            binding.layout.setBackgroundResource(R.drawable.background_input_active)
        } else {
            binding.layout.setBackgroundResource(R.drawable.background_input)
        }
    }

    private fun setupFocusListener() {
        binding.input.setOnFocusChangeListener { _, hasFocus ->
            setupViewFocusStatus(hasFocus)
            this.text = binding.input.text.toString()
        }
    }

    private fun setupOnClickListener() {
        binding.startIcon.setOnClickListener {
            startIconOnClick()
        }
        binding.endIcon.setOnClickListener {
            endIconOnClick()
        }
    }

    fun startIconIsClickable(isClickable: Boolean) {
        binding.startIcon.isClickable = isClickable
    }

    fun endIconIsClickable(isClickable: Boolean) {
        binding.endIcon.isClickable = isClickable
    }
}