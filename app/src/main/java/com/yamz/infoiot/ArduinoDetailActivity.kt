package com.yamz.infoiot

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ArduinoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arduino_detail)

        val arduino = intent.getSerializableExtra("arduino") as Arduinos

        val nameTextView = findViewById<TextView>(R.id.textview_arduino_name)
        val descriptionTextView = findViewById<TextView>(R.id.textview_arduino_description)
        val imageView = findViewById<ImageView>(R.id.imageview_arduino)

        nameTextView.text = arduino.nombre
        descriptionTextView.text = arduino.descripcion

        // Setear la imagen si está disponible
        arduino.imagenResId?.let {
            imageView.setImageResource(it)
            imageView.visibility = View.VISIBLE
        }
    }
}
