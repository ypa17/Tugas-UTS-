package com.example.minggu4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_marquee.*
import kotlinx.android.synthetic.main.activity_pengumuman.*
import org.json.JSONObject

class PengumumanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengumuman)

        getdariserver()
    }

    fun getdariserver(){
        AndroidNetworking.get("http://10.0.0.25/cobarepo/pengumuman_json.php")
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject?) {
                    Log.e("_kotlinResponse", response.toString())

                    //val jsonArray = response.getJSONArray("result")
                    val jsonArray = response!!.getJSONArray("result")
                    for (i in 0 until jsonArray.length()){
                        val jsonObject = jsonArray.getJSONObject(i)
                        Log.e("_kotlinTittle",jsonObject.optString("id_pengumuman"))

                        pengumuman4.setText(jsonObject.optString( "id_pengumuman"))
                        pengumuman1.setText(jsonObject.optString("judul_pengumuman"))
                        pengumuman2.setText(jsonObject.optString("isi_pengumuman"))
                        pengumuman3.setText(jsonObject.optString("aktif"))

                    }
                }
                override fun onError(anError: ANError){
                    Log.i("_err",anError.toString())
                }

            })
    }
}
