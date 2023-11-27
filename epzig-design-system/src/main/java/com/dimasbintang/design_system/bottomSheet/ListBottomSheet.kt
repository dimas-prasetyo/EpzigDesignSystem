package com.dimasbintang.design_system.bottomSheet

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.dimasbintang.design_system.databinding.ListBottomSheetViewBinding
import com.dimasbintang.design_system.dropdown.adapter.DropdownAdapter
import com.dimasbintang.design_system.model.ItemDropdown
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ListBottomSheet(
    private val context: Context,
    private val items: List<ItemDropdown>,
    private val isMultipleSelect: Boolean = true,
    private val btnText: String = "Confirm"
): BottomSheetDialogFragment() {
    private lateinit var binding: ListBottomSheetViewBinding
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var adapter: ListAdapter
    var confirmListener: () -> Unit = {}

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.setOnShowListener {
            val d = it as BottomSheetDialog
            val bottomSheet =
                d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        }

        return dialog
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListBottomSheetViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rectangle = Rect()
        requireActivity().window.decorView.getWindowVisibleDisplayFrame(rectangle)
        val child = view as ViewGroup

        val childParam = child.layoutParams as FrameLayout.LayoutParams
        child.layoutParams = childParam
        binding.btnDone.text = btnText

        adapter = ListAdapter(context, items, isMultipleSelect)
        binding.recyclerView.adapter = adapter

        setOnClickListener()
    }

    private fun setOnClickListener() {
        binding.root.setOnClickListener {
            val behavior = BottomSheetBehavior.from(view?.parent as View)
            if (behavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                items.forEach { it.isSelected = false }
                adapter.notifyDataSetChanged()
                dismiss()
            }
        }

        adapter.onClick = { item, position ->

        }

        binding.btnDone.setOnClickListener {
            confirmListener()
            dismiss()
        }
    }
}