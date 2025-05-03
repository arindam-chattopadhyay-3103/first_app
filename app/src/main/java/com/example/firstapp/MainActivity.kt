package com.example.firstapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private val textView = findViewById<TextView>(R.id.helloTextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = getString(R.string.my_documents)
        textView.contentDescription = getString(R.string.my_documents) + "content"
    }

}