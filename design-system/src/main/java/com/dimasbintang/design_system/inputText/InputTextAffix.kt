package com.dimasbintang.design_system.inputText

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.InputTextAffixViewBinding
import com.google.android.material.textfield.TextInputEditText

@SuppressLint("ResourceType")
class InputTextAffix @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private val binding: InputTextAffixViewBinding

    var text: String
        get() = binding.input.text.toString()
        set(value) = binding.input.setText(value)

    init {
        val inflater = LayoutInflater.from(context)
        binding = InputTextAffixViewBinding.inflate(inflater, this)


        val set = intArrayOf(
            R.attr.title,
            android.R.attr.text,
            R.attr.hint,
            R.attr.prefixText,
            R.attr.suffixText,
            android.R.attr.enabled,
        )

        val a = context.obtainStyledAttributes(attrs, set)
        val title = a.getText(0) ?: ""
        val text = a.getText(1) ?: ""
        val hint = a.getText(2) ?: ""
        val prefixText = a.getText(3) ?: ""
        val suffixText = a.getText(4) ?: ""
        val isEnabled = a.getBoolean(5, true)

        binding.title.isVisible = title.isNotBlank()
        binding.title.text = title
        binding.input.hint = if (hint.isNotBlank()) hint else if (title.isNotBlank()) title else ""
        binding.prefix.isVisible = prefixText.isNotBlank()
        binding.suffix.isVisible = suffixText.isNotBlank()
        binding.prefix.text = prefixText
        binding.suffix.text = suffixText
        binding.input.isEnabled = isEnabled
        this.text = text.toString()

        setupFocusListener()
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

}