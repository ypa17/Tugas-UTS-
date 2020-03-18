package com.example.minggu4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getdariserver()

        btnkembali.setOnClickListener(){
            val intent = Intent( this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }

    fun getdariserver(){
        AndroidNetworking.get("http://10.0.0.25/cobarepo/contoh_jadwal_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    //val jsonArray = response.getJSONArray("result")
                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle",jsonObject.optString("dhuha"))

                        txt6.setText(jsonObject.optString( "dhuha"))
                        txt1.setText(jsonObject.optString( "shubuh"))
                        txt2.setText(jsonObject.optString("dhuhur"))
                        txt3.setText(jsonObject.optString("ashar"))
                        txt4.setText(jsonObject.optString("maghrib"))
                        txt5.setText(jsonObject.optString("isha"))

                    }
                }
                override fun onError(anError: ANError){
                    Log.i("_err",anError.toString())
                }

            })
    }


}
