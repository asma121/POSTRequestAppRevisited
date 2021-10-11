package com.example.postrequestapprevisited

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {
    lateinit var etnumber: EditText
    lateinit var etname2: EditText
    lateinit var etlocation2: EditText
    lateinit var budel: Button
    lateinit var buup: Button
    var input=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        etnumber=findViewById(R.id.etnumber)
        etname2=findViewById(R.id.etname2)
        etlocation2=findViewById(R.id.etlocation2)
        budel=findViewById(R.id.budel)
        buup=findViewById(R.id.buup)

        budel.setOnClickListener {
            input=etnumber.text.toString().toInt()
            delUserDetails(input)
        }

        buup.setOnClickListener {
            input=etnumber.text.toString().toInt()
            var f = UserDetails.Datum(etname2.text.toString(), etlocation2.text.toString())
            upDateUserDetails(input,f)
        }
    }

    private fun delUserDetails(id:Int){
        val apiInterface = APIClient().getClinet()?.create(APIInterface::class.java)
        if (apiInterface != null) {
            apiInterface.delUserDetails(id)?.enqueue(object : Callback<Void> {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {
                    Toast.makeText(applicationContext,"User Deleted", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Something went wrong", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

    private fun upDateUserDetails(id:Int,userdata: UserDetails.Datum){
        val apiInterface = APIClient().getClinet()?.create(APIInterface::class.java)
        if (apiInterface != null) {
            apiInterface.upDateUserDetails(id,userdata)?.enqueue(object : Callback<UserDetails.Datum> {
                override fun onResponse(call: Call<UserDetails.Datum>, response: Response<UserDetails.Datum>) {
                    Toast.makeText(applicationContext,"User Update", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<UserDetails.Datum>, t: Throwable) {
                    Toast.makeText(applicationContext,"Something went wrong", Toast.LENGTH_LONG).show()
                }
            })
        }
    }

}