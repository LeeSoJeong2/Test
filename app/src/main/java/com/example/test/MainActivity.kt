package com.example.test

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById<View>(R.id.textView) as TextView

        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener { showMessage() }
    }

    fun showMessage() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("안내")
        builder.setMessage("종료하시겠습니까?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton(
            "예"
        ) { dialog, which ->
            Snackbar.make(textView!!, "예 버튼이 눌렸습니다.", Snackbar.LENGTH_LONG).show()
        }
        builder.setNegativeButton(
            "아니요"
        ) { dialog, which ->
            Snackbar.make(textView!!, "아니오 버튼이 눌렸습니다.", Snackbar.LENGTH_LONG).show()
        }
        val dialog = builder.create()
        dialog.show()
    }
}