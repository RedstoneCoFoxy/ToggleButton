package com.example.togglebutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ToggleButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button : ToggleButton = findViewById(R.id.buttonmain)
        button.setOnCheckedChangeListener(){ _, isChecked ->
            if (isChecked) {
                button.setTextColor(Color.rgb(0, 0, 0))
                button.setBackgroundColor(Color.rgb(250, 255, 0))
            } else {
                button.setTextColor(Color.rgb(255, 255, 255))
                button.setBackgroundColor(Color.rgb(138, 0, 255))
            }
        }
    }
}