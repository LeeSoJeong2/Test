package com.example.test

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val permissionCheck =
            ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS)
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "SMS 수신 권한 주어져 있음.", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "SMS 수신 권한 없음. ", Toast.LENGTH_LONG).show()
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this,
                    Manifest.permission.RECEIVE_SMS
                )
            ) {
                Toast.makeText(this, "SMS 권한 설명 필요", Toast.LENGTH_LONG).show()
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.RECEIVE_SMS), 1)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> if (grantResults.size > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "SMS 수신 권한을 사용자가 승인함,", Toast.LENGTH_LONG).show()
                } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    Toast.makeText(this, "SMS 수신 권한을 사용자가 거부함,", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "SMS 수신 권한을 부여받지 못함,", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}