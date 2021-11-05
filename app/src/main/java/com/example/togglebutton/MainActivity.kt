package com.example.togglebutton

import android.graphics.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.core.graphics.BitmapCompat

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
        var buttonRed : ToggleButton = findViewById(R.id.buttonred)
        var buttonGreen : ToggleButton = findViewById(R.id.buttongreen)
        var buttonBlue : ToggleButton = findViewById(R.id.buttonblue)

        val bitmapDog = BitmapFactory.decodeResource(resources,R.drawable.pies)
        val bitmapRed = BitmapFactory.decodeResource(resources,R.drawable.czerwony)
        val bitmapGrn = BitmapFactory.decodeResource(resources,R.drawable.zielony)
        val bitmapBlu = BitmapFactory.decodeResource(resources,R.drawable.niebieski)

        val bitmapFilterR = Bitmap.createBitmap(bitmapDog.width, bitmapDog.height, Bitmap.Config.ARGB_8888)
        val bitmapFilterG = Bitmap.createBitmap(bitmapDog.width, bitmapDog.height, Bitmap.Config.ARGB_8888)
        val bitmapFilterB = Bitmap.createBitmap(bitmapDog.width, bitmapDog.height, Bitmap.Config.ARGB_8888)
        var Obrazek : ImageView = findViewById(R.id.imageView)

        val paint = Paint()
        paint.alpha=100
        val canvasRed = Canvas(bitmapFilterR)
        val canvasGreen = Canvas(bitmapFilterG)
        val canvasBlue = Canvas(bitmapFilterB)
        canvasRed.drawARGB(0,0,0,0)
        canvasBlue.drawARGB(0,0,0,0)
        canvasGreen.drawARGB(0,0,0,0)

        canvasRed.drawBitmap(bitmapRed,null,
            RectF(0f,0f,bitmapDog.width.toFloat(),bitmapDog.height.toFloat()),paint)
        canvasRed.drawBitmap(bitmapDog,0f,0f,paint)

        canvasGreen.drawBitmap(bitmapGrn,null,
            RectF(0f,0f,bitmapDog.width.toFloat(),bitmapDog.height.toFloat()),paint)
        canvasGreen.drawBitmap(bitmapDog,0f,0f,paint)

        canvasBlue.drawBitmap(bitmapBlu,null,
            RectF(0f,0f,bitmapDog.width.toFloat(),bitmapDog.height.toFloat()),paint)
        canvasBlue.drawBitmap(bitmapDog,0f,0f,paint)

        buttonRed.setOnCheckedChangeListener(){ _, isChecked ->
            if (isChecked) {
                Obrazek.setImageBitmap(bitmapFilterR)
            } else {
                Obrazek.setImageBitmap(bitmapDog)
            }
        }
        buttonGreen.setOnCheckedChangeListener(){ _, isChecked ->
            if (isChecked) {
                Obrazek.setImageBitmap(bitmapFilterG)
            } else {
                Obrazek.setImageBitmap(bitmapDog)
            }
        }
        buttonBlue.setOnCheckedChangeListener(){ _, isChecked ->
            if (isChecked) {
                Obrazek.setImageBitmap(bitmapFilterB)
            } else {
                Obrazek.setImageBitmap(bitmapDog)
            }
        }
    }
}