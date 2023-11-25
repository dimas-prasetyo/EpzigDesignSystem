package com.dimasbintang.design_system.bottomSheet


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.ItemDropdownBinding
import com.dimasbintang.design_system.model.ItemDropdown

class ListAdapter(private val context: Context, private val items: List<ItemDropdown>, private val isMultipleSelect: Boolean) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    var onClick: (item: ItemDropdown, position: Int) -> Unit = {_,_->}
    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDropdownBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.binding) {
        val item = items[position]
        text.text = item.text
        startIcon.isVisible = item.startIcon != null
        endIcon.isVisible = item.endIcon != null

        startIcon.setImageDrawable(item.startIcon)
        item.endIcon?.let { endIcon.setImageDrawable(it) }
        val backgroundColor = if (item.isSelected) R.color.brand_100 else R.color.translucent
        background.setCardBackgroundColor(context.getColor(backgroundColor))

        root.setOnClickListener {
            if (isMultipleSelect) {
                item.isSelected = !item.isSelected
                val text = items.filter { it.isSelected }.size.takeIf { size -> size > 0 } ?.let { "$it Selected" } ?: ""
                notifyItemChanged(position)
            } else {
                items.forEachIndexed { index, item ->
                    item.isSelected = index == position
                }
                notifyDataSetChanged()
            }
            onClick(item, position)
        }
    }
    class ViewHolder(val binding: ItemDropdownBinding): RecyclerView.ViewHolder(binding.root)
}