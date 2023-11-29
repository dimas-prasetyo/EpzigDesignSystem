package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.dimasbintang.design_system.helper.BoxiconMapper.getDrawableBoxicon
import com.dimasbintang.design_system.helper.DropdownMapper.addItemDropdown
import com.dimasbintang.design_system.model.ItemDropdown
import com.dimasbintang.epzigdesignsystem.databinding.ActivityInputChooseBinding

class InputChooseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputChooseBinding
    private var singleSelectItems = arrayListOf<ItemDropdown>()
    private var multipleSelectItems = arrayListOf<ItemDropdown>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputChooseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDummyData()

        binding.inputDropdown.setItemDropdown(singleSelectItems)
        binding.inputDropdown.onSelectedItem = {
            // action
        }

        binding.inputDropdownMultiple.setItemDropdown(multipleSelectItems)
        binding.inputDropdownMultiple.onSelectedItem = {
            // action
        }
    }

    private fun setDummyData() {

        singleSelectItems.addItemDropdown("Alarm", getDrawableBoxicon(this, "bx_alarm"))
        singleSelectItems.addItemDropdown("Search", getDrawableBoxicon(this, "bx_search"))
        singleSelectItems.addItemDropdown("Shield", getDrawableBoxicon(this, "bx_shield"))
        singleSelectItems.addItemDropdown("Trash", getDrawableBoxicon(this, "bx_trash"))
        singleSelectItems.addItemDropdown("Plus",  getDrawableBoxicon(this, "bx_plus"))
        singleSelectItems.addItemDropdown("Minus",  getDrawableBoxicon(this, "bx_minus"))


        multipleSelectItems.addItemDropdown("Alarm", getDrawableBoxicon(this, "bx_alarm"))
        multipleSelectItems.addItemDropdown("Search", getDrawableBoxicon(this, "bx_search"))
        multipleSelectItems.addItemDropdown("Shield", getDrawableBoxicon(this, "bx_shield"))
        multipleSelectItems.addItemDropdown("Trash", getDrawableBoxicon(this, "bx_trash"))
        multipleSelectItems.addItemDropdown("Plus",  getDrawableBoxicon(this, "bx_plus"))
        multipleSelectItems.addItemDropdown("Minus",  getDrawableBoxicon(this, "bx_minus"))



        //multipleSelectItems.addItemDropdown("Alarm", ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_alarm))
    }
}