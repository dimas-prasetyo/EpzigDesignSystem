package com.dimasbintang.design_system.textWatcher

import com.dimasbintang.design_system.R

enum class PasswordStrength(val result: String, val bars: Int, val color: Int) {
    WEAK("Weak", 1, R.color.rose_600),
    MEDIUM("Medium", 2, R.color.amber_600),
    GOOD("Good", 3, R.color.teal_600),
    GREAT("Great", 4, R.color.teal_600),
}
