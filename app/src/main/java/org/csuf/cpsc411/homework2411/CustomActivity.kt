package org.csuf.cpsc411.homework2411

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.TypedArrayUtils.getText
import com.loopj.android.http.AsyncHttpClient.log

class CustomActivity : AppCompatActivity() {
    lateinit var cList : MutableList<Claim>
    lateinit var cService : ClaimService
    lateinit var shMessage : String

    fun refreshScreen() {
        //
        Log.d("Person Service", "Refreshing the Screen.")
        val titleView : EditText = findViewById(R.id.cTitle)
        val dateView : EditText = findViewById(R.id.date)
        val statusView : TextView = findViewById(R.id.status)

        val titleI = titleView.getText().toString()
        val dateI = dateView.getText().toString()
        var cObj = Claim("0", titleI, dateI, false)
        if(titleI != "" && dateI != "") {
            cService = ClaimService(this)
            cService.addClaim(cObj)

            titleView.getText().clear()
            dateView.getText().clear()
            statusView.setText(shMessage)
        }
        //else {
        //    statusView.setText("Claim unsuccessfully created")
        //}

        //enable/disable the button
        //val nBtn : Button = findViewById(R.id.input)
        //nBtn.setEnabled()
    }

    fun statusMessage(sMessage : String) {
        shMessage = sMessage
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fldRowGenerator = ObjDetailScreenGenerator(this)
        val colView = fldRowGenerator.generate()
        setContentView(colView)
        //
        val bView : Button = findViewById(R.id.input)
        bView.setOnClickListener {
            //get the next Person object
            refreshScreen()
        }
    }
}