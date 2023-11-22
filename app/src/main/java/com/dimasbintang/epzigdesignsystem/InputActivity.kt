package com.dimasbintang.epzigdesignsystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.dimasbintang.design_system.helper.DropdownMapper.addItemDropdown
import com.dimasbintang.design_system.model.ItemDropdown
import com.dimasbintang.epzigdesignsystem.databinding.ActivityInputBinding

class InputActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.inputTextIcon.startIconIsClickable(false)
        val itemsPertama = arrayListOf<ItemDropdown>()
        val itemsKedua = arrayListOf<ItemDropdown>()
        // Icon Text
        itemsPertama.addItemDropdown("Alarm", ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_alarm))
        itemsPertama.addItemDropdown("Search", ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_search))
        // Text only
        itemsPertama.addItemDropdown("Shield")
        itemsPertama.addItemDropdown("Trash")
        // Text Icon
        itemsPertama.addItemDropdown("Plus", null, ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_plus))
        itemsPertama.addItemDropdown("Album", null, ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_album))


        // Icon Text
        itemsKedua.addItemDropdown("Alarm", ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_alarm))
        itemsKedua.addItemDropdown("Search", ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_search))
        // Text only
        itemsKedua.addItemDropdown("Shield")
        itemsKedua.addItemDropdown("Trash")
        // Text Icon
        itemsKedua.addItemDropdown("Plus", null, ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_plus))
        itemsKedua.addItemDropdown("Album", null, ContextCompat.getDrawable(this, com.dimasbintang.design_system.R.drawable.bx_album))

        binding.inputDropdownSingle.setItemDropdown(itemsPertama)
        binding.inputDropdownSingle.onSelectedItem = { item ->
            Toast.makeText(this, "Terpilih: ${item.text}", Toast.LENGTH_SHORT).show()
        }

        binding.inputDropdownMultiple.setItemDropdown(itemsKedua)
        binding.inputDropdownMultiple.onSelectedItem = { item ->
            Toast.makeText(this, "Terpilih: ${binding.inputDropdownMultiple.selectedItems.size}", Toast.LENGTH_SHORT).show()
        }*/
    }
}