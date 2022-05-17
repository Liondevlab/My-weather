package com.liondevlab.myweather.city

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.liondevlab.myweather.R

/**
 * My Weather
 * Created by LioNDeVLaB on 17/05/2022
 */
class CreateCityDialogFragment : DialogFragment() {

    interface CreateCityDialogListener {
        fun onDialogPositiveClick(cityName: String)
        fun onDialogNegativeClick()
    }

    var listener: CreateCityDialogListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)

        val input = EditText(context)
        with(input) {
            inputType = InputType.TYPE_CLASS_TEXT
            hint = context.getString(R.string.create_city_hint)
        }

        builder.setTitle(R.string.create_city_title)
            .setView(input)
            .setPositiveButton(R.string.create_city_button,
            DialogInterface.OnClickListener {_, _ ->
                listener?.onDialogPositiveClick(input.text.toString())
            })
            .setNegativeButton(R.string.create_city_cancel,
            DialogInterface.OnClickListener {dialog, _ ->
                dialog.cancel()
                listener?.onDialogNegativeClick()
            })

        return builder.create()
    }
}