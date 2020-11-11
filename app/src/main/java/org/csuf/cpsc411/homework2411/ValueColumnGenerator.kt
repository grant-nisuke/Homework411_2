package org.csuf.cpsc411.homework2411

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout

class ValueColumnGenerator(val ctx : Context) {
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.BLACK)
        //
        val vParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        vParams.bottomMargin = 5
        //
        var value = EditText(ctx)
        value.id = R.id.cTitle
        value.setHint("Enter Claim Title")
        value.textSize = 25.00f
        value.setBackgroundColor(Color.WHITE)
        layoutObj.addView(value, vParams)
        //
        //vParams.topMargin = 5
        value = EditText(ctx)
        value.id = R.id.date
        value.setHint("Enter date")
        value.textSize = 25.00f
        value.setBackgroundColor(Color.WHITE)
        layoutObj.addView(value, vParams)
        return layoutObj
    }
}