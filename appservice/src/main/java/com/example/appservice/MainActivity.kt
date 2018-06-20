package com.example.appservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }
    private fun loadData() {
        val listTeam = mutableListOf<String>()
        val call = RetrofitService.endpoint.getTeam()
        call.enqueue(object: Callback<List<Team>> {

            override fun onFailure(call: Call<List<Team>>?, t: Throwable?) {
                progressBar2.visibility = View.GONE

            }

            override fun onResponse(call: Call<List<Team>>?, response: Response<List<Team>>?) {
                progressBar2.visibility = View.GONE
                if (response?.isSuccessful!!) {
                    val list:List<Team> = response.body()!!
                    for (item in list) {
                        listTeam.add(item.team_name)
                    }
                    val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, listTeam)
                    listView.adapter = adapter
                } else {
                    Toast.makeText(applicationContext, response.toString(), Toast.LENGTH_SHORT).show()

                }
            }

        })
    }
}
