package com.dimasbintang.design_system.textWatcher

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class PasswordTextWatcher(editText: EditText, private val passwordStrengthListener: (PasswordStrength) -> Unit) : TextWatcher {
    private val editText: EditText

    init {
        this.editText = editText
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Sebelum teks berubah
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // Ketika teks berubah
    }

    override fun afterTextChanged(editable: Editable?) {
        val password = editText.text.toString()
        passwordStrengthCheck(password)
    }

    private fun passwordStrengthCheck(password: String) {
        val length = password.length
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { it.isLetterOrDigit().not() }

        val isLengthGood = length >= 8

        val result = when {
            isLengthGood && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar -> PasswordStrength.GREAT
            isLengthGood && (hasUpperCase || hasLowerCase) && hasDigit -> PasswordStrength.GOOD
            isLengthGood && (hasUpperCase || hasLowerCase) -> PasswordStrength.MEDIUM
            else -> PasswordStrength.WEAK
        }
        passwordStrengthListener(result)

    }

}