package com.dimasbintang.design_system.helper

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.dimasbintang.design_system.model.ItemDropdown

object DropdownMapper {
    fun ArrayList<ItemDropdown>.addItemDropdown(text: String, startIcon: Drawable? = null, endIcon: Drawable? = null, isSelected: Boolean = false) {
        val itemDropdown = ItemDropdown(text, startIcon, endIcon, isSelected)
        this.add(itemDropdown)
    }

    fun Int.toDrawable(context: Context): Drawable? {
        return ContextCompat.getDrawable(context, this)
    }
}