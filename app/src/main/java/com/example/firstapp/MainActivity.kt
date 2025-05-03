package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(saveIns: Bundle?) {
        super.onCreate(saveIns)
        setContentView(R.layout.activity_main)
    }

}