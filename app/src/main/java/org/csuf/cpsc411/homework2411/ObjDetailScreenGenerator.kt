package org.csuf.cpsc411.homework2411

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout

class ObjDetailScreenGenerator(val ctx : Context) {
    lateinit var layoutObj: LinearLayout
    fun generate() : LinearLayout {
        //1. Create a LinearLayout Object
        layoutObj = LinearLayout(ctx)
        val lParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        layoutObj.layoutParams = lParams
        layoutObj.orientation = LinearLayout.VERTICAL
        layoutObj.setBackgroundColor(Color.WHITE)

        //1.5
        val titleGenerator = Titleinfo(ctx)
        val titleView = titleGenerator.generate()
        layoutObj.addView(titleView)

        //2  Add ObjDetailSection
        val fldRowGenerator = ObjDetailSectionGenerator(ctx)
        val colView = fldRowGenerator.generate()
        layoutObj.addView(colView)

        //3. Add Next Button LinearLayout
        val nLayout = LinearLayout(ctx)
        val nParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        //
        nParams.gravity = Gravity.RIGHT
        nLayout.layoutParams = nParams
        nLayout.orientation = LinearLayout.HORIZONTAL
        nLayout.setBackgroundColor(Color.WHITE)
        //
        val nButton = Button(ctx)
        nButton.text = "Add"
        nButton.setId(R.id.input)
        nButton.textSize = 25.00f
        nButton.setTextColor(Color.DKGRAY)
        nButton.setBackgroundColor(Color.GRAY)
        val nbParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        nbParams.gravity = Gravity.BOTTOM
        nLayout.addView(nButton, nbParams)

        layoutObj.addView(nLayout)

        //4th part
        //val zzz = StatusValueGenerator(ctx)
        //val newView = zzz.generate()
        //layoutObj.addView(newView)
        val jStat = JointStatus(ctx)
        val jView = jStat.generate()
        layoutObj.addView(jView)

        return layoutObj
    }
}