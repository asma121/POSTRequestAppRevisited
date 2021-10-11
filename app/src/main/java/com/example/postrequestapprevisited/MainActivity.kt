package com.example.postrequestapprevisited

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var buupdate: Button
    lateinit var buadd: Button
    lateinit var rvmain:RecyclerView
    var userdata:List<UserDetails.Datum>?=null
    var displayResponse =ArrayList<ArrayList<String>>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buadd= findViewById(R.id. buadd)
        buupdate= findViewById(R.id. buupdate)
        rvmain=findViewById(R.id.rvmain)

        getUserDetails(onResult = {
            userdata = it
            val datumList = userdata
            for (datum in datumList!!) {
                displayResponse+= arrayListOf(arrayListOf("${datum.pk}","${datum.name}","${datum.location}"))
            }
            rvmain.adapter=myAdapter(displayResponse)
            rvmain.layoutManager= LinearLayoutManager(this)
        })

        buadd.setOnClickListener {
            val intent=Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }

        buupdate.setOnClickListener {
            val intent=Intent(this,MainActivity3::class.java)
            startActivity(intent)
        }
    }

    private fun getUserDetails(onResult: (List<UserDetails.Datum>?) -> Unit) {
        val apiInterface = APIClient().getClinet()?.create(APIInterface::class.java)
        if (apiInterface != null) {
            apiInterface.getUserDetails()?.enqueue(object : Callback<List<UserDetails.Datum>> {
                override fun onResponse(
                    call: Call<List<UserDetails.Datum>>,
                    response: Response<List<UserDetails.Datum>>
                ) {
                    onResult(response.body())
                }

                override fun onFailure(call: Call<List<UserDetails.Datum>>, t: Throwable) {
                    onResult(null)
                }

            })
        }
    }
}