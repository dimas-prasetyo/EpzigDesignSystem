package com.dimasbintang.design_system.textWatcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.dimasbintang.design_system.helper.NumberConverter.convertToNumber
import com.dimasbintang.design_system.helper.NumberConverter.convertToString
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.ParseException
import java.util.Locale

class NumberTextWatcher(editText: EditText, decimalSeparator: CharSequence = ".", isSupportDecimal: Boolean = true, private val numberListener: (Number) -> Unit) : TextWatcher {
    private val editText: EditText
    private var decimalSeparator: CharSequence = "."
    private var isSupportDecimal = true

    init {
        this.editText = editText
        this.decimalSeparator = decimalSeparator
        this.isSupportDecimal = isSupportDecimal
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(editable: Editable?) {
        val value = editText.text.toString()
        if (value.isNotBlank()) {
            val initialLength = editText.text.length
            val lastPosition = editText.selectionStart
            var inputText = if (isSupportDecimal) value else value.replace(decimalSeparator.toString(), "")

            inputText = if (decimalSeparator != "."){
                inputText.replace(".", "")
            } else {
                inputText.replace(",", "")
            }

            inputText = inputText.replace(",", ".")
            val formattedText = if (inputText.contains(".")){
                val parts = inputText.split(".")
                if (parts[0].isNotEmpty()){
                    if (parts[1].isNotEmpty()){
                        "${parts[0].toBigDecimal().convertToString(decimalSeparator)}$decimalSeparator${parts[1]}"
                    } else {
                        "${parts[0].toBigDecimal().convertToString(decimalSeparator)}$decimalSeparator"
                    }
                } else {
                    "0"
                }
            } else {
                inputText.toBigDecimal().convertToString(decimalSeparator)
            }

            editText.removeTextChangedListener(this)
            editText.setText(formattedText)

            val newPosition = lastPosition + (formattedText.length - initialLength)
            editText.setSelection(if (newPosition < formattedText.length && newPosition > 0) newPosition else formattedText.length)
            editText.addTextChangedListener(this)

            numberListener(formattedText.convertToNumber(decimalSeparator))
        }
    }
}