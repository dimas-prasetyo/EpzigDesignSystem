package com.dimasbintang.design_system.helper

import android.graphics.drawable.Drawable
import com.dimasbintang.design_system.model.ItemDropdown

object DropdownMapper {
    fun ArrayList<ItemDropdown>.addItemDropdown(text: String, startIcon: Drawable? = null, endIcon: Drawable? = null, isSelected: Boolean = false) {
        val itemDropdown = ItemDropdown(text, startIcon, endIcon, isSelected)
        this.add(itemDropdown)
    }
}