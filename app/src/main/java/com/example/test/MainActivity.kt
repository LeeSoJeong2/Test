package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    lateinit var imageView:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<View>(R.id.textView) as TextView
        imageView = findViewById<View>(R.id.imageView) as ImageView

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            sendRequest()
        }

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            sendImageRequest()
        }

        AppHelper.requestQueue = Volley.newRequestQueue(applicationContext)

    }

    fun sendImageRequest() {
        val url = "https://movie-phinf.pstatic.net/20211207_37/1638855505310al8KU_JPEG/movie_image.jpg?type=m665_443_2"
        val task = ImageLoadTask(url, imageView)
        task.execute()
    }

    fun sendRequest() {
        val url = "\thttp://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101"
        val request: StringRequest = object : StringRequest(
            Method.GET,
            url,
            Response.Listener {
                    response -> println("응답 -> $response")
                              processResponse(response)},
            Response.ErrorListener { error -> println("에러 -> " + error.message) }
        ) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                return HashMap()
            }
        }

        request.setShouldCache(false)
        AppHelper.requestQueue.add(request)
        println("요청 보냄.")
    }

    fun processResponse(response:String){
        val gson = Gson()
        var movieList:MovieList? = gson.fromJson(response, MovieList::class.java)

        if (movieList != null) {
            val countMovie = movieList.boxOfficeResult?.dailyBoxOfficeList?.size
            println("박스오피스 타입 : " + movieList.boxOfficeResult?.boxOfficeType)
            println("응답받은 영화 갯수 : $countMovie")

        }
    }

    fun println(data:String) {
        textView.append(data + "\n")
    }

}