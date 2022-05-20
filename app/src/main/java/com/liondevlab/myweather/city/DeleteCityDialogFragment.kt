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
 * Created by LioNDeVLaB on 20/05/2022
 */
class DeleteCityDialogFragment: DialogFragment() {

    interface DeleteCityDialogListener {
        fun onDialogPositiveClick()
        fun onDialogNegativeClick()
    }

    companion object {

        val EXTRA_CITY_NAME = "com.liondevlab.myweather.extras.EXTRA_CITY_NAME"

        fun newInstance(cityName: String) : DeleteCityDialogFragment {
            val fragment = DeleteCityDialogFragment()
            fragment.arguments = Bundle().apply {
                putString(EXTRA_CITY_NAME, cityName)
            }
            return fragment
        }
    }

    var listener: DeleteCityDialogListener? = null
    private lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cityName = requireArguments().getString(EXTRA_CITY_NAME).toString()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)

        builder.setTitle(getString(R.string.delete_city_title, cityName))
            .setPositiveButton(
                R.string.delete_city_button)
            { _, _ ->
                listener?.onDialogPositiveClick()
            }
            .setNegativeButton(
                R.string.delete_city_cancel)
            { _, _ ->
                listener?.onDialogNegativeClick()
            }

        return builder.create()
    }
}