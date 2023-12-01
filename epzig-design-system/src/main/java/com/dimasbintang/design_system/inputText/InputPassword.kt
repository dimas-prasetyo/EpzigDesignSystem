package com.dimasbintang.design_system.inputText

import android.annotation.SuppressLint
import android.content.Context
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.dimasbintang.design_system.R
import com.dimasbintang.design_system.databinding.InputPasswordViewBinding
import com.dimasbintang.design_system.textWatcher.PasswordStrength
import com.dimasbintang.design_system.textWatcher.PasswordTextWatcher
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.textfield.TextInputEditText

@SuppressLint("ResourceType")
class InputPassword @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private val binding: InputPasswordViewBinding
    private var isPasswordVisible = false
    var editText: TextInputEditText

    var text: String
        get() = binding.input.text.toString()
        set(value) = binding.input.setText(value)

    init {
        val inflater = LayoutInflater.from(context)
        binding = InputPasswordViewBinding.inflate(inflater, this)
        editText = binding.input

        val set = intArrayOf(
            R.attr.title,
            R.attr.hint,
            android.R.attr.enabled,
        )

        val a = context.obtainStyledAttributes(attrs, set)
        val title = a.getText(0) ?: ""
        val hint = a.getText(1) ?: ""
        val isEnabled = a.getBoolean(2, true)

        binding.title.isVisible = title.isNotBlank()
        binding.title.text = title
        binding.input.hint = if (hint.isNotBlank()) hint else if (title.isNotBlank()) title else ""
        binding.input.isEnabled = isEnabled
        setupFocusListener()
        setupOnClickListener()

        binding.input.addTextChangedListener(PasswordTextWatcher(binding.input) { strength ->
            binding.layoutError.isVisible = text.isNotBlank()
            binding.passwordStatus.text = strength.result
            binding.passwordStatus.setTextColor(context.getColor(strength.color))
            binding.layoutStrengthBar.removeAllViews()
            text.takeIf { it.isNotBlank() }?.let { setupStrengthBarIndicator(strength) }

        })

        /*viewTreeObserver.addOnGlobalLayoutListener {
            setupStrengthBarIndicator()
        }*/
        a.recycle()
    }

    private fun setupStrengthBarIndicator(strength: PasswordStrength? = null) {
        val margin = resources.getDimensionPixelSize(R.dimen.margin_extra_small)
        val barHeight = resources.getDimensionPixelSize(R.dimen.bar_height_small)
        val screenWidth = binding.layoutStrengthBar.width

        val imageWidth = (screenWidth - (3 * margin)) / 4

        repeat(4) { iteration ->
            val strengthBar = ShapeableImageView(context)
            val params = GridLayout.LayoutParams().apply {
                width = imageWidth
                height = barHeight
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            }

            val marginParams = MarginLayoutParams(params).apply {
                marginStart = if (iteration > 0) {
                    margin
                } else {
                    0
                }
            }

            strengthBar.layoutParams = params
            strengthBar.shapeAppearanceModel =
                ShapeAppearanceModel().toBuilder().setAllCorners(
                    CornerFamily.ROUNDED, 4f
                ).build()

            strengthBar.setImageResource(R.color.lightGray)
            strength?.let { passwordStrength ->
                val colorRes = when (passwordStrength) {
                    PasswordStrength.WEAK -> R.color.rose_600
                    PasswordStrength.MEDIUM -> R.color.amber_600
                    PasswordStrength.GOOD -> R.color.teal_600
                    PasswordStrength.GREAT -> R.color.teal_600
                }

                if (iteration < passwordStrength.bars) {
                    strengthBar.setImageResource(colorRes)
                }
            }
            binding.layoutStrengthBar.addView(strengthBar, marginParams)
        }
    }

    private fun setupViewFocusStatus(hasFocus: Boolean) {
        if (hasFocus) {
            binding.layout.setBackgroundResource(R.drawable.background_input_active)
        } else {
            binding.layout.setBackgroundResource(R.drawable.background_input)
        }
    }

    private fun setupFocusListener() {
        binding.input.setOnFocusChangeListener { _, hasFocus ->
            setupViewFocusStatus(hasFocus)
            this.text = binding.input.text.toString()
        }
    }

    private fun setupOnClickListener() {
        binding.endIcon.setOnClickListener {
            isPasswordVisible = !isPasswordVisible
            if (isPasswordVisible) {
                binding.input.transformationMethod = HideReturnsTransformationMethod.getInstance()
            } else {
                binding.input.transformationMethod = PasswordTransformationMethod.getInstance()
            }
            binding.input.setSelection(binding.input.text?.length ?: 0)
            binding.endIcon.setImageResource(if (isPasswordVisible) R.drawable.bx_show else R.drawable.bx_hide)
        }
    }

}