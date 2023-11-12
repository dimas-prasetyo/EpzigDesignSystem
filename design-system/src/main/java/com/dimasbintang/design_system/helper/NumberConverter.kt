package com.dimasbintang.design_system.helper

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

object NumberConverter {
    fun Number.convertToString(decimalSeparator: CharSequence = "."): String {

        val decimalSymbols= if (decimalSeparator == ".") {
            DecimalFormatSymbols.getInstance(Locale.US)
        } else {
            DecimalFormatSymbols.getInstance(Locale.GERMAN)
        }
        val decimalFormat = DecimalFormat("#,###,###.##", decimalSymbols)
        return decimalFormat.format(this)
    }


    fun String.convertToNumber(decimalSeparator: CharSequence = "."): Number {
        return try {
            var sanitizedInput = if (endsWith(decimalSeparator)) "${this}0" else this
            return if (decimalSeparator in sanitizedInput) {
                sanitizedInput = sanitizedInput.replace(",", ".")
                sanitizedInput.toDouble()
            } else {
                sanitizedInput.toInt()
            }
        } catch (e: NumberFormatException) {
            0
        }
    }

    fun Number?.convertToDouble(): Double {
        return this?.toDouble() ?: 0.0
    }

    fun Number?.convertToInt(): Int {
        return this?.toInt() ?: 0
    }
}