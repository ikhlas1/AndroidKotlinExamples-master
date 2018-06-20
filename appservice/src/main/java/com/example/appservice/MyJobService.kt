package com.example.appservice

import android.widget.Toast
import com.firebase.jobdispatcher.JobParameters
import com.firebase.jobdispatcher.JobService
import kotlinx.android.synthetic.main.activity_formulaire.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Titouche on 23-May-18.
 */
class MyJobService: JobService() {
    var jobParameters:JobParameters? = null
    override fun onStopJob(job: JobParameters?)= true

    override fun onStartJob(job: JobParameters?): Boolean {
        this.jobParameters = job
        val teams = RoomService.appDatabase.getTeamDao().getTeams().get(0)
        addTeams(teams)
        return true

    }

    private fun addTeams(team: Team) {
        val result = RetrofitService.endpoint.addTeam(team)
        result.enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>?, t: Throwable?) {
                jobFinished(jobParameters!!, true)
            }

            override fun onResponse(call: Call<String>?, response: Response<String>?) {
               if(response?.isSuccessful!!){
                   RoomService.appDatabase.getTeamDao().deleteTeam(team)
                   jobFinished(jobParameters!!, false)
               } else
                   jobFinished(jobParameters!!, true)
            }

        })


    }
}