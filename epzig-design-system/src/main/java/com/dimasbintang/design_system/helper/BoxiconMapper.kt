package com.dimasbintang.design_system.helper

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

object BoxiconMapper {
    fun getDrawableBoxicon(context: Context, iconName: String): Drawable? {
        val resourceId = context.resources.getIdentifier(iconName, "drawable", context.packageName)
        return if (resourceId != 0) {
            ContextCompat.getDrawable(context, resourceId)
        } else {
            null
        }
    }

}