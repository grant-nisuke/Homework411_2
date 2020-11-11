package org.csuf.cpsc411.homework2411

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class LableColumnGenerator(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        val layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.BLACK)
        //
        val lbParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        lbParams.weight = 10.0f
        lbParams.bottomMargin = 5
        //
        var lbl = TextView(ctx)
        lbl.text = "Claim Title"
        lbl.gravity = Gravity.CENTER
        lbl.textSize = 25.00f
        lbl.setBackgroundColor(Color.GRAY)
        layoutObj.addView(lbl, lbParams)
        //
        lbl = TextView(ctx)
        lbl.text = "Date"
        lbl.setBackgroundColor(Color.GRAY)
        lbl.gravity = Gravity.CENTER
        lbl.textSize = 25.00f
        layoutObj.addView(lbl, lbParams)
        lbl = TextView(ctx)
        //
        return layoutObj
    }

}