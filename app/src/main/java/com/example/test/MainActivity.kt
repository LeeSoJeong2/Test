package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val curId = item.itemId
        when (curId) {
            R.id.menu_refresh -> Toast.makeText(this, "새로고침 메뉴 클릭됨.", Toast.LENGTH_LONG).show()
            R.id.menu_search -> Toast.makeText(this, "검색 메뉴 클릭됨.", Toast.LENGTH_LONG).show()
            R.id.menu_settings -> Toast.makeText(this, "설정 메뉴 클릭됨.", Toast.LENGTH_LONG).show()
            else -> {}
        }
        return super.onOptionsItemSelected(item)
    }
}