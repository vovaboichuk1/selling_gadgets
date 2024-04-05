package com.cricoo.selling_gadgets

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.PopupWindow
import android.widget.TextView
import com.cricoo.selling_gadgets.Laptop
import com.cricoo.selling_gadgets.R

class LaptopPopup(context: Context, laptop: Laptop) {
    private val popupView: View
    private val popupWindow: PopupWindow

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        popupView = inflater.inflate(R.layout.popup_layout, null)

        val textViewName = popupView.findViewById<TextView>(R.id.textViewName)
        val textViewDetails = popupView.findViewById<TextView>(R.id.textViewDetails)

        textViewName.text = laptop.name
        textViewDetails.text = laptop.details

        popupWindow = PopupWindow(
            popupView,
            WRAP_CONTENT,
            WRAP_CONTENT
        )

        popupWindow.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        popupWindow.isOutsideTouchable = true
        popupWindow.isFocusable = true
    }

    fun show(view: View) {
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }
}
