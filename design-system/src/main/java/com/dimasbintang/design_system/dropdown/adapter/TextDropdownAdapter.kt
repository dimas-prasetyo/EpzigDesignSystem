package com.dimasbintang.design_system.dropdown.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.dimasbintang.design_system.databinding.ItemTextDropdownBinding
import com.dimasbintang.design_system.model.TextDropdown
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class TextDropdownAdapter (context: Context, items: List<TextDropdown>): ArrayAdapter<TextDropdown>(context, 0, items)  {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemTextDropdownBinding
        val holder: ViewHolder

        if (convertView == null) {
            binding = ItemTextDropdownBinding.inflate(LayoutInflater.from(context), parent, false)
            holder = ViewHolder(binding)
            binding.root.tag = holder
        } else {
            binding = ItemTextDropdownBinding.bind(convertView)
            holder = binding.root.tag as ViewHolder
        }

        val item = getItem(position)
        holder.text.text = item?.text

        return binding.root
    }

    class ViewHolder(val binding: ItemTextDropdownBinding)  {
        val text: MaterialTextView = binding.text
        val background: MaterialCardView = binding.background
    }
}