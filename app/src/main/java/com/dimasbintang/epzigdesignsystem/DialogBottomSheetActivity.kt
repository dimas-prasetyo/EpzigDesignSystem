package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dimasbintang.design_system.helper.DropdownMapper.addItemDropdown
import com.dimasbintang.design_system.helper.DropdownMapper.toDrawable
import com.dimasbintang.design_system.model.ItemDropdown
import com.dimasbintang.epzigdesignsystem.databinding.ActivityDialogBottomSheetBinding

class DialogBottomSheetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogBottomSheetBinding
    private var textOnlyItems = arrayListOf<ItemDropdown>()
    private var leftIconItems = arrayListOf<ItemDropdown>()
    private var rightIconItems = arrayListOf<ItemDropdown>()
    private var bothIconItems = arrayListOf<ItemDropdown>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDummyData()
        setOnClickListener()
    }

    private fun setDummyData() {
        textOnlyItems.addItemDropdown("January")
        textOnlyItems.addItemDropdown("February")
        textOnlyItems.addItemDropdown("March")
        textOnlyItems.addItemDropdown("April")
        textOnlyItems.addItemDropdown("May")

        leftIconItems.addItemDropdown("Justify", com.dimasbintang.design_system.R.drawable.bx_align_justify.toDrawable(this))
        leftIconItems.addItemDropdown("Left", com.dimasbintang.design_system.R.drawable.bx_align_left.toDrawable(this))
        leftIconItems.addItemDropdown("Middle", com.dimasbintang.design_system.R.drawable.bx_align_middle.toDrawable(this))
        leftIconItems.addItemDropdown("Right", com.dimasbintang.design_system.R.drawable.bx_align_right.toDrawable(this))

        rightIconItems.addItemDropdown("Justify", null, com.dimasbintang.design_system.R.drawable.bx_align_justify.toDrawable(this))
        rightIconItems.addItemDropdown("Left", null, com.dimasbintang.design_system.R.drawable.bx_align_left.toDrawable(this))
        rightIconItems.addItemDropdown("Middle", endIcon = com.dimasbintang.design_system.R.drawable.bx_align_middle.toDrawable(this))
        rightIconItems.addItemDropdown("Right", endIcon = com.dimasbintang.design_system.R.drawable.bx_align_right.toDrawable(this))

        bothIconItems.addItemDropdown("Justify", com.dimasbintang.design_system.R.drawable.bx_align_justify.toDrawable(this), com.dimasbintang.design_system.R.drawable.bx_chevrons_up.toDrawable(this))
        bothIconItems.addItemDropdown("Left", com.dimasbintang.design_system.R.drawable.bx_align_left.toDrawable(this), com.dimasbintang.design_system.R.drawable.bx_chevrons_right.toDrawable(this))
        bothIconItems.addItemDropdown("Middle", com.dimasbintang.design_system.R.drawable.bx_align_middle.toDrawable(this), com.dimasbintang.design_system.R.drawable.bx_chevrons_left.toDrawable(this))
        bothIconItems.addItemDropdown("Right", com.dimasbintang.design_system.R.drawable.bx_align_right.toDrawable(this), com.dimasbintang.design_system.R.drawable.bx_chevrons_down.toDrawable(this))
    }

    private fun setOnClickListener() {

    }

}