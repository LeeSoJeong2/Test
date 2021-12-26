package com.example.test

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.text.format.DateFormat.format
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class SMSReceiver : BroadcastReceiver() {
    private val TAG = "SmsReceiver"
    private val format = SimpleDateFormat("yyyy-MM-dd HH:mm")

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Log.d(TAG, "onReceive() 호출됨.")

        val bundle = intent.extras
        val messages = parseSmsMessage(bundle!!)

        if (messages!!.size > 0) {
            val sender = messages[0]!!.originatingAddress
            Log.d(TAG, "sender : $sender")
            val contents = messages[0]!!.messageBody.toString()
            Log.d(TAG, "contents : $contents")
            val receivedDate = Date(messages[0]!!.timestampMillis)
            Log.d(TAG, "received date : $receivedDate")

            sendToActivity(context, sender!!, contents, receivedDate)
        }
    }

    private fun sendToActivity(
        context: Context,
        sender: String,
        contents: String,
        receivedDate: Date
    ) {
        val intent = Intent(context, SmsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("sender", sender)
        intent.putExtra("contents", contents)
        intent.putExtra("receivedDate", format.format(receivedDate))
        context.startActivity(intent)
    }

    private fun parseSmsMessage(bundle: Bundle): Array<SmsMessage?>? {
        val objs = bundle["pdus"] as Array<Any>?
        val messages = arrayOfNulls<SmsMessage>(
            objs!!.size
        )
        for (i in objs.indices) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val format = bundle.getString("format")
                messages[i] = SmsMessage.createFromPdu(objs[i] as ByteArray, format)
            } else {
                messages[i] = SmsMessage.createFromPdu(objs[i] as ByteArray)
            }
        }
        return messages
    }
}