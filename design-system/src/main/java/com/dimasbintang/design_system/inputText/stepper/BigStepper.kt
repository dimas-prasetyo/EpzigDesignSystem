package com.dimasbintang.design_system.inputText.stepper

import android.content.Context
import android.util.AttributeSet
import com.dimasbintang.design_system.R

class BigStepper @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : BaseStepper(context, attrs) {

    init {
        val inputParams = binding.input.layoutParams
        inputParams.height = resources.getDimensionPixelSize(R.dimen.size_big)
        binding.input.layoutParams = inputParams

        val btnParams = binding.btnMinus.layoutParams
        btnParams.width = resources.getDimensionPixelSize(R.dimen.size_big)
        btnParams.height = resources.getDimensionPixelSize(R.dimen.size_big)

        binding.btnMinus.layoutParams = btnParams
        binding.btnPlus.layoutParams = btnParams
    }
}