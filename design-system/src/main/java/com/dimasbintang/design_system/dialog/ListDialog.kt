package com.dimasbintang.design_system.dialog

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.bottomSheet.ListAdapter
import com.dimasbintang.design_system.databinding.DialogListBinding
import com.dimasbintang.design_system.model.ItemDropdown

class ListDialog(
    private val context: Context,
    private val items: List<ItemDropdown>,
    private val isMultipleSelect: Boolean = true,
    private val title: String = "",
    private val positiveText: String = "",
    private val negativeText: String = "",
    private val onClick: () -> Unit = {},
): DialogFragment() {
    private lateinit var binding: DialogListBinding
    private lateinit var adapter: ListAdapter
    var confirmListener: () -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = title
        binding.title.isVisible = title.isNotBlank()
        binding.btnConfirm.text = positiveText.takeIf { it.isNotBlank() } ?: "Confirm"
        binding.btnCancel.text = negativeText.takeIf { it.isNotBlank() } ?: "Cancel"

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val displayMetrics = resources.displayMetrics
        val maxWidthPx = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            550.toFloat(),
            resources.displayMetrics
        ).toInt()

        val width = minOf(displayMetrics.widthPixels, maxWidthPx) - (resources.getDimensionPixelSize(
            R.dimen.margin_extra_large
        ) * 2)
        dialog?.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        adapter = ListAdapter(context, items, isMultipleSelect)
        binding.recyclerView.adapter = adapter

        adapter.onClick = { item, position ->

        }

        setOnClickListener()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setOnClickListener() {
        dialog?.window?.decorView?.setOnTouchListener { _, event ->
            val rect = Rect()
            binding.root.getGlobalVisibleRect(rect)

            if (!rect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                items.forEach { it.isSelected = false }
                adapter.notifyDataSetChanged()
                dismiss()
                return@setOnTouchListener true
            }
            false
        }
        binding.btnCancel.setOnClickListener {
            items.forEach { it.isSelected = false }
            adapter.notifyDataSetChanged()
            dialog?.dismiss()
        }
        binding.btnConfirm.setOnClickListener {
            confirmListener()
            dialog?.dismiss()
        }
    }
}