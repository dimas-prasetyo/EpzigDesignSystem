package com.dimasbintang.design_system.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.DialogConfirmationBinding

class DialogConfirmation(
    private val title: String,
    private val message: String = "",
    private val positiveText: String = "",
    private val negativeText: String = ""
): DialogFragment() {
    private lateinit var binding: DialogConfirmationBinding
    var positiveListener: () -> Unit = {}
    var negativeListener: () -> Unit = {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = title
        binding.message.text = message
        binding.btnConfirm.text = positiveText.takeIf { it.isNotBlank() } ?: "Confirm"
        binding.btnCancel.text = negativeText.takeIf { it.isNotBlank() } ?: "Cancel"

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        //dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)

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

        binding.iconClose.setOnClickListener {
            dialog?.dismiss()
        }
        binding.btnCancel.setOnClickListener {
            negativeListener()
        }
        binding.btnConfirm.setOnClickListener {
            positiveListener()
        }
    }
}