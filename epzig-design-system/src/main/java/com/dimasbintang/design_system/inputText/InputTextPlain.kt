package com.dimasbintang.design_system.inputText

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.InputTextPlainViewBinding
import com.dimasbintang.design_system.model.StyleSize.BIG
import com.dimasbintang.design_system.model.StyleSize.MEDIUM
import com.dimasbintang.design_system.model.StyleSize.SMALL
import com.google.android.material.textfield.TextInputEditText
import java.util.Locale

@SuppressLint("ResourceType")
class InputTextPlain @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private val binding: InputTextPlainViewBinding
    var editText: TextInputEditText

    var text: String
        get() = binding.input.text.toString()
        set(value) = binding.input.setText(value)

    init {
        val inflater = LayoutInflater.from(context)
        binding = InputTextPlainViewBinding.inflate(inflater, this)
        editText = binding.input

        val set = intArrayOf(
            R.attr.title,
            android.R.attr.text,
            R.attr.hint,
            R.attr.styleSize,
            android.R.attr.enabled,
        )

        val a = context.obtainStyledAttributes(attrs, set)
        val title = a.getText(0) ?: ""
        val text = a.getText(1) ?: ""
        val hint = a.getText(2) ?: ""
        val size = a.getText(3) ?: MEDIUM
        val isEnabled = a.getBoolean(4, true)

        this.text = text.toString()
        binding.title.isVisible = title.isNotBlank()
        binding.title.text = title
        binding.input.hint = if (hint.isNotBlank()) hint else if (title.isNotBlank()) title else ""
        binding.input.isEnabled = isEnabled
        a.recycle()
    }
}