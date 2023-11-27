package com.dimasbintang.design_system.model

import android.graphics.drawable.Drawable

data class ItemDropdown(
    val text: String,
    val startIcon: Drawable? = null,
    val endIcon: Drawable? = null,
    var isSelected: Boolean = false
)
