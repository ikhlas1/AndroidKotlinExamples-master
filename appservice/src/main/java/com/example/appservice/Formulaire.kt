package com.example.appservice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.jobdispatcher.*
import kotlinx.android.synthetic.main.activity_formulaire.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Formulaire : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire)

        button.setOnClickListener { view ->
//            insertData()
            val team = Team(team_name = team_name.text.toString(),continent = continent.text.toString())
            RoomService.appDatabase.getTeamDao().addTeams(team)
            team_name.text.clear()
            continent.text.clear()
            scheduleSync()
        }
    }

    private fun scheduleSync() {
        val dispatcher = FirebaseJobDispatcher(GooglePlayDriver(this))
        val myJob =
                dispatcher?.newJobBuilder() .setService(MyJobService::class.java)
                        .setRecurring(false) // exécuter une fois
                        .setTag("my-tag") // identifiant du service
                        .setLifetime(Lifetime.FOREVER) // durée de vie
                        .setTrigger(Trigger.executionWindow(10, 30)) // temps de lancement
                        .setRetryStrategy(RetryStrategy.DEFAULT_LINEAR) // stratégie de relance
                        .setConstraints(Constraint.ON_UNMETERED_NETWORK) // mode WiFi
                        .build()
        dispatcher?.mustSchedule(myJob)
    }

//    private fun insertData() {
//        val team = Team (id_team.text.toString().toInt(),team_name.text.toString(), continent.text.toString())
//        val call = RetrofitService.endpoint.addTeam(team)
//        call.enqueue(object: Callback<String>{
//            override fun onFailure(call: Call<String>?, t: Throwable?) {
//                Toast.makeText(applicationContext, "Failed to insert data!", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(call: Call<String>?, response: Response<String>?) {
//                Toast.makeText(applicationContext, "Data inserted successfully.", Toast.LENGTH_SHORT).show()
//            }
//
//
//        })
//    }
}
