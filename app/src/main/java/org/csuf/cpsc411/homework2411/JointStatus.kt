package org.csuf.cpsc411.homework2411

import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout

class JointStatus(val ctx : Context) {
    lateinit var layoutObj : LinearLayout
    fun generate() : LinearLayout {
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.HORIZONTAL
        layoutObj.setBackgroundColor(Color.WHITE)
        //
        val lcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        val colGenerator = StatusLabelGenerator(ctx)
        var lblView = colGenerator.generate()
        lcParams.weight = 2.0F
        layoutObj.addView(lblView, lcParams)
        //
        val valGenerator = StatusValueGenerator(ctx)
        val vcParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        lblView = valGenerator.generate()
        vcParams.marginStart = 5
        vcParams.weight = 4F
        layoutObj.addView(lblView, vcParams)
        return layoutObj
    }
}