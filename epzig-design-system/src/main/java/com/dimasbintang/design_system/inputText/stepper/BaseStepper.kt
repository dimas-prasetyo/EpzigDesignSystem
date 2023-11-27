package com.dimasbintang.design_system.inputText.stepper

import android.annotation.SuppressLint
import android.content.Context
import android.text.InputType
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.StepperViewBinding
import com.dimasbintang.design_system.helper.NumberConverter.convertToDouble
import com.dimasbintang.design_system.helper.NumberConverter.convertToNumber
import com.dimasbintang.design_system.helper.NumberConverter.convertToString
import com.dimasbintang.design_system.textWatcher.NumberTextWatcher

@SuppressLint("ResourceType")
open class BaseStepper @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    val binding: StepperViewBinding
    private var decimalSeparator: CharSequence = "."
    var value: Number = 0
    private var minValue: Number? = null
    private var maxValue: Number? = null

    var text: String
        get() = binding.input.text.toString()
        set(value) = binding.input.setText(value)

    init {
        val inflater = LayoutInflater.from(context)
        binding = StepperViewBinding.inflate(inflater, this)

        val set = intArrayOf(
            android.R.attr.hint,
            R.attr.decimalSeparator,
            R.attr.supportsDecimal,
            android.R.attr.enabled,
        )

        val a = context.obtainStyledAttributes(attrs, set)
        val hint = a.getText(0) ?: ""
        decimalSeparator = a.getText(1) ?: "."
        val isSupportDecimal = a.getBoolean(2, true)
        val isEnabled = a.getBoolean(3, true)

        binding.input.inputType = InputType.TYPE_NUMBER_FLAG_DECIMAL
        binding.input.keyListener = DigitsKeyListener.getInstance("0123456789,.")
        binding.input.hint = hint.ifBlank { "0" }
        binding.input.isEnabled = isEnabled
        setupOnClickListener()

        binding.input.addTextChangedListener(NumberTextWatcher(binding.input, decimalSeparator, isSupportDecimal) {
            value = it
            minValue?.let { binding.btnMinus.isEnabled = value.convertToDouble() <= minValue.convertToDouble() }
            maxValue?.let { binding.btnPlus.isEnabled = value.convertToDouble() >= maxValue.convertToDouble() }
        })

        a.recycle()
    }

    private fun setupOnClickListener() {
        binding.btnMinus.setOnClickListener {
            value = text.convertToNumber(decimalSeparator).convertToDouble() - 1
            text = value.convertToString(decimalSeparator)
        }
        binding.btnPlus.setOnClickListener {
            value = text.convertToNumber(decimalSeparator).convertToDouble() + 1
            text = value.convertToString(decimalSeparator)
        }
    }

    fun setMinValue(minValue: Number) {
        this.minValue = minValue
    }

    fun setMaxValue(maxValue: Number) {
        this.maxValue = maxValue
    }
}