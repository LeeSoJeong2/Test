package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.test.data.MovieList
import com.example.test.data.ResponseInfo
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            requestMovieList()
        }

        AppHelper.requestQueue = Volley.newRequestQueue(applicationContext)


    }

    fun requestMovieList() {
        var url = "http://" + AppHelper.host + ":" + AppHelper.port + "/movie/readMovieList"
        url += "?" + "type=1"

        val request = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener {
                println("응답 받음 -> $it")
                processResponse(it)
            },
            Response.ErrorListener {
                println("에러 발생 -> ${it.message}")
            }
        )
        request.setShouldCache(false)
        AppHelper.requestQueue.add(request)
        println("영화목록 요청 보냄.")

    }

    fun processResponse(response: String) {
        val gson = Gson()
        val info = gson.fromJson(response, ResponseInfo::class.java)

        if (info.code == 200) {
            val movieList = gson.fromJson(response, MovieList::class.java)
            println("영화 갯수 : " + movieList.result.size)

            for (i in 0 until movieList.result.size) {
                val movieInfo = movieList.result[i]
                println("영화 # $i : -> ${movieInfo.id}, ${movieInfo.title}, ${movieInfo.grade} ")
            }
        }

    }

    fun println(data:String){
        textView.append(data + "\n")
    }
}