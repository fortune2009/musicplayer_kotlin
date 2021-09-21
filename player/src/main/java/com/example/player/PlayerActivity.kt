package com.example.player

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

open class PlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)
    }
}