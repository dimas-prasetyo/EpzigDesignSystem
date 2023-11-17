package com.dimasbintang.design_system.dropdown

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.InputDropdwonBinding
import com.dimasbintang.design_system.dropdown.adapter.DropdownAdapter
import com.dimasbintang.design_system.model.ItemDropdown

@SuppressLint("ResourceType", "ClickableViewAccessibility")
class InputDropdown @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private val binding: InputDropdwonBinding
    var onSelectedItem: (item: ItemDropdown) -> Unit = {}
    private var items = arrayListOf<ItemDropdown>()
    private var isMultipleSelect = false

    val selectedItems: List<ItemDropdown>
        get() = items.filter { it.isSelected }

    init {
        val inflater = LayoutInflater.from(context)
        binding = InputDropdwonBinding.inflate(inflater, this)

        val set = intArrayOf(
            R.attr.title,
            android.R.attr.text,
            R.attr.hint,
            R.attr.isMultipleSelect,
            android.R.attr.enabled,
        )

        val a = context.obtainStyledAttributes(attrs, set)
        val title = a.getText(0) ?: ""
        val text = a.getText(1) ?: ""
        val hint = a.getText(2) ?: ""
        isMultipleSelect = a.getBoolean(3, false)
        val isEnabled = a.getBoolean(4, true)

        binding.title.isVisible = title.isNotBlank()
        binding.title.text = title

        if (text.isNotBlank()) {
            binding.text.text = text
        } else if (hint.isNotBlank()) {
            binding.text.hint = hint
        }

        binding.autoCompleteView.dropDownVerticalOffset = (5 * resources.displayMetrics.density + 0.5f).toInt()
        binding.autoCompleteView.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    binding.autoCompleteView.showDropDown()
                    binding.autoCompleteView.requestFocus()
                    return@setOnTouchListener true
                }
            }
            false
        }
        a.recycle()
    }

    fun setItemDropdown(itemsDropdown: List<ItemDropdown>) {
        items.addAll(itemsDropdown)
        val adapter = DropdownAdapter(context, items)
        binding.autoCompleteView.setAdapter(adapter)

        binding.autoCompleteView.setOnItemClickListener { parent, _, position, _ ->
            binding.autoCompleteView.text.clear()
            binding.autoCompleteView.clearFocus()


            val selectedItem = parent?.getItemAtPosition(position) as ItemDropdown
            if (isMultipleSelect) {
                items[position].isSelected = !items[position].isSelected
                val text = items.filter { it.isSelected }.size.takeIf { size -> size > 0 } ?.let { "$it Selected" } ?: ""
                binding.text.text = text
            } else {
                binding.icon.isVisible = selectedItem.startIcon != null
                binding.icon.setImageDrawable(selectedItem.startIcon)
                binding.text.text = selectedItem.text
                items.forEachIndexed { index, item ->
                    item.isSelected = index == position
                }
            }
            adapter.notifyDataSetChanged()

            val horizontalPadding = resources.getDimensionPixelSize(if (binding.icon.isVisible) R.dimen.spacing_empty else R.dimen.spacing_semi_medium)
            binding.text.setPadding(horizontalPadding, binding.text.paddingTop, horizontalPadding, binding.text.paddingBottom)
            onSelectedItem(selectedItem)
        }
    }

    /*fun setItemDropdown(itemsDropdown: List<ItemDropdown>) {
        items.addAll(itemsDropdown)
        //val adapter = DropdownAdapter(context, items)
        //binding.autoCompleteView.setAdapter(adapter)

        binding.autoCompleteView.setOnClickListener {
            showPopup()
            println("KLIK AUTO VIEW")
        }
    }
    private fun showPopup() {
        val popupWindow = PopupWindow(context)
        val recyclerView = RecyclerView(context)
        recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = DropdownAdapter(context, items)
        recyclerView.adapter = adapter

        popupWindow.contentView = recyclerView
        popupWindow.width = binding.autoCompleteView.width
        popupWindow.isFocusable = true

        // Menentukan lokasi pop-up window
        val location = IntArray(2)
        binding.autoCompleteView.getLocationOnScreen(location)

        // Menyesuaikan posisi
        *//*popupWindow.showAtLocation(
            binding.autoCompleteView,
            Gravity.NO_GRAVITY,
            location[0],
            location[1] + binding.autoCompleteView.height
        )*//*
        popupWindow.showAsDropDown(binding.autoCompleteView)

        adapter.onClickListener = { selectedItem, position ->

            binding.autoCompleteView.text.clear()
            binding.autoCompleteView.clearFocus()


            //val selectedItem = parent?.getItemAtPosition(position) as ItemDropdown
            if (isMultipleSelect) {
                items[position].isSelected = !items[position].isSelected
                val text = items.filter { it.isSelected }.size.takeIf { size -> size > 0 } ?.let { "$it Selected" } ?: ""
                binding.text.text = text
            } else {
                binding.icon.isVisible = selectedItem.startIcon != null
                binding.icon.setImageDrawable(selectedItem.startIcon)
                binding.text.text = selectedItem.text
                items.forEachIndexed { index, item ->
                    item.isSelected = index == position
                }
            }
            adapter.notifyDataSetChanged()

            val horizontalPadding = resources.getDimensionPixelSize(if (binding.icon.isVisible) R.dimen.spacing_empty else R.dimen.spacing_semi_medium)
            binding.text.setPadding(horizontalPadding, binding.text.paddingTop, horizontalPadding, binding.text.paddingBottom)
            onSelectedItem(selectedItem)
        }

    }*/
}