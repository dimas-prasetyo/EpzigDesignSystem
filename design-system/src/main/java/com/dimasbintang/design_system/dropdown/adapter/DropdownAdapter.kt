package com.dimasbintang.design_system.dropdown.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.ItemDropdownBinding
import com.dimasbintang.design_system.model.ItemDropdown

class DropdownAdapter(context: Context, items: List<ItemDropdown>): ArrayAdapter<ItemDropdown>(context, 0, items)  {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemDropdownBinding
        val holder: ViewHolder

        if (convertView == null) {
            binding = ItemDropdownBinding.inflate(LayoutInflater.from(context), parent, false)
            holder = ViewHolder(binding)
            binding.root.tag = holder
        } else {
            binding = ItemDropdownBinding.bind(convertView)
            holder = binding.root.tag as ViewHolder
        }

        val item = getItem(position)
        binding.text.text = item?.text
        binding.startIcon.isVisible = item?.startIcon != null
        binding.endIcon.isVisible = item?.endIcon != null

        binding.startIcon.setImageDrawable(item?.startIcon)
        item?.endIcon?.let { binding.endIcon.setImageDrawable(it) }
        val backgroundColor = if (item?.isSelected == true) R.color.brand_100 else R.color.translucent
        binding.background.setCardBackgroundColor(context.getColor(backgroundColor))

        return binding.root
    }

    class ViewHolder(val binding: ItemDropdownBinding) {}
}

/*
class DropdownAdapter(val context: Context, private val items: List<ItemDropdown>): RecyclerView.Adapter<DropdownAdapter.ViewHolder>() {


    var onClickListener: (item: ItemDropdown, position: Int) -> Unit = {_,_->}
    class ViewHolder(val binding: ItemDropdownBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDropdownBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder){
        val item = items[position]
        binding.text.text = item?.text
        binding.startIcon.isVisible = item?.startIcon != null
        binding.endIcon.isVisible = item?.endIcon != null

        binding.startIcon.setImageDrawable(item?.startIcon)
        item?.endIcon?.let { binding.endIcon.setImageDrawable(it) }
        val backgroundColor = if (item?.isSelected == true) R.color.brand_100 else R.color.translucent
        binding.background.setCardBackgroundColor(context.getColor(backgroundColor))
        onClickListener(item, position)
    }
}*/
