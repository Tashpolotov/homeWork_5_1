package com.example.homework_5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework_5_1.databinding.ActivityMainBinding
import com.example.homework_5_1.presentation.view.EmojiAdapter
import com.example.homework_5_1.presentation.view.NumberAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initialize()
    }

    private fun initialize() {
      //  ui.rvMain.adapter = NumberAdapter()
        ui.rvMain.adapter = EmojiAdapter()

    }
}