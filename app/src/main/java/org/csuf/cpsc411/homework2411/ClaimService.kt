package org.csuf.cpsc411.homework2411

import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import cz.msebera.android.httpclient.entity.StringEntity
import java.lang.reflect.Type

class ClaimService(val ctx: CustomActivity) {

        // var personList : List<Person> = mutableListOf()
        lateinit var claimList : MutableList<Claim>
        var currentIndex : Int = 0


        fun lastOne() : Claim {
            return claimList[claimList.count()-1]
        }

        inner class GetAllServiceRespHandler : AsyncHttpResponseHandler(){
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray
            ) {
                // JSON string
                if (responseBody != null)
                    Log.d("Claim Service","The response JSON string is ${String(responseBody)}")
                val  gson = Gson()
                val claimListType: Type = object : TypeToken<List<Claim>>(){}.type
                claimList = gson.fromJson(String(responseBody), claimListType)
                Log.d("Claim Service", "The Person List: ${claimList}"  )
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Log.d("GetAllService", "Failed")
            }

        }

        inner class AddServiceRespHandler : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                if(responseBody != null) {
                    val respStr = String(responseBody)
                    Log.d("Claim Service", "The add Service response : ${respStr}")
                    ctx.refreshStatusTrue()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                //if(responseBody != null) {
                //val respStr = String(responseBody)
                //    Log.d("Claim Service", "The add Service response : ${respStr}")
                    ctx.refreshStatusFalse()
               // }
            }

        }

        fun addClaim(cObj : Claim) {
            val client = AsyncHttpClient()
            val requestUrl = "http://192.168.56.1:8080/ClaimService/add"
            //1. Convert the pObj into JSON string
            val pJsonString = Gson().toJson(cObj)
            //2. Send the post request
            val entity = StringEntity(pJsonString)
            //3. ctx is an Android Application Context Object
            client.post(ctx, requestUrl, entity, "application/json", AddServiceRespHandler())
        }

        fun getAll() {
            //var pList : List<Person> = mutableListOf()
            // Call Http
            val client = AsyncHttpClient()
            val requestUrl = "http://192.168.56.1:8080/ClaimService/getAll"
            //
            Log.d("Claim Service", "About Sending the Http Request.")
            client.get(requestUrl, GetAllServiceRespHandler())
        }
}
