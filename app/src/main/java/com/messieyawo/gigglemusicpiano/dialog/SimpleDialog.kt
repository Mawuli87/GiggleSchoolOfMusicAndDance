package com.messieyawo.gigglemusicpiano.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.messieyawo.gigglemusicpiano.databinding.DialogSimpleBinding


class SimpleDialog : XDialogFragment() {

    private lateinit var binding: DialogSimpleBinding
    private var positiveListener: OnClickListener? = null
    private var negativeListener: OnClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogSimpleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        isCancelable = false
        arguments?.getInt(ARG_KEY_ICON)?.let {
            if (it != 0) {
                binding.ivDialogIcon.setImageResource(it)
            }
        }
        arguments?.getInt(ARG_KEY_TITLE)?.let {
            if (it != 0) {
                binding.tvDialogTitle.setText(it)
            }
        }
        arguments?.getString(ARG_KEY_DESCRIPTION)?.let {
            if (it.isNotEmpty()) {
                binding.tvDialogDescription.text = it
            }
        }
        arguments?.getInt(ARG_KEY_BUTTON_POSITIVE)?.let {
            if (it != 0) {
                binding.btDialogPositive.setText(it)
            }
        }
        arguments?.getInt(ARG_KEY_BUTTON_NEGATIVE)?.let {
            if (it != 0) {
                binding.btDialogNegative.setText(it)
            }
        }

        binding.btDialogPositive.setOnClickListener {
            dismiss()
            positiveListener?.invoke()
        }
        binding.btDialogNegative.setOnClickListener {
            dismiss()
            negativeListener?.invoke()
        }
    }

    fun setOnPositiveClickListener(listener: OnClickListener) {
        positiveListener = listener
    }

    fun setOnNegativeClickListener(listener: OnClickListener) {
        negativeListener = listener
    }

    companion object {
        const val TAG = "SimpleDialogInstance"
        private const val ARG_KEY_TITLE = "arg_key_title"
        private const val ARG_KEY_DESCRIPTION = "arg_key_description"
        private const val ARG_KEY_BUTTON_POSITIVE = "arg_key_button_positive"
        private const val ARG_KEY_BUTTON_NEGATIVE = "arg_key_button_negative"
        private const val ARG_KEY_ICON = "arg_key_icon"

        fun newInstance(
            @DrawableRes iconResId: Int?,
            @StringRes titleResId: Int?,
            description: String?,
            @StringRes positiveButtonResId: Int?,
            @StringRes negativeButtonResId: Int?
        ) = SimpleDialog().apply {
            arguments = Bundle().apply {
                iconResId?.let {
                    putInt(ARG_KEY_ICON, it)
                }
                titleResId?.let {
                    putInt(ARG_KEY_TITLE, it)
                }
                description?.let {
                    putString(ARG_KEY_DESCRIPTION, it)
                }
                positiveButtonResId?.let {
                    putInt(ARG_KEY_BUTTON_POSITIVE, it)
                }
                negativeButtonResId?.let {
                    putInt(ARG_KEY_BUTTON_NEGATIVE, it)
                }
            }
        }
    }
}

typealias OnClickListener = () -> Unit