package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    lateinit var buttonWhatsApp: Button
    lateinit var uriString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uriString = "Go to link : https://www.youtube.com/watch?v=W8MjnsJ820E"
        buttonWhatsApp = findViewById<Button>(R.id.whatsapp_button)
        buttonWhatsApp.setOnClickListener {
            whatsappShare(uriString)
        }
    }

    fun whatsappShare(uriString: String) {
        try {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, uriString)
            intent.setPackage("com.whatsapp")
            startActivity(intent)
        } catch (exception: Exception) {
            Toast.makeText(
                applicationContext,
                "$exception :: Whatsapp not installed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}