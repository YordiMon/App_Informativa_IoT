package com.yamz.infoiot

import ArduinoAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArduinoActivity : AppCompatActivity(), ArduinoAdapter.OnArduinoClickListener {

    private val arduinoList = listOf(
        Arduinos("Arduino Uno", "Placa de desarrollo básica.", R.drawable.arduinouno),
        Arduinos("Arduino Mega", "Placa de desarrollo con más puertos y memoria.", R.drawable.arduinomega),
        Arduinos("Arduino Nano", "Pequeña placa con tamaño reducido.", R.drawable.arduinonano),
        Arduinos("Arduino Leonardo", "Placa con chip ATmega32u4 y USB nativo.", R.drawable.arduinoleonardo),
        Arduinos("Arduino Due", "Placa con procesador ARM de 32 bits.", R.drawable.arduinodue),
        Arduinos("Arduino Pro Mini", "Placa compacta diseñada para proyectos permanentes.", R.drawable.arduinomini),
        Arduinos("Arduino Pro Micro", "Placa compacta con chip ATmega32u4.", R.drawable.arduinomicro),
        Arduinos("Arduino MKR1000", "Placa con conectividad WiFi.", R.drawable.arduinomkr1000),
        Arduinos("Arduino MKR Zero", "Placa con procesador SAMD21 de 32 bits.", R.drawable.arduinomkrzero),
        Arduinos("Arduino MKR FOX 1200", "Placa con conectividad Sigfox.", R.drawable.arduinomkrfox1200),
        Arduinos("Arduino MKR WAN 1300", "Placa con conectividad LoRa.", R.drawable.arduinowan1300),
        Arduinos("Arduino MKR GSM 1400", "Placa con conectividad GSM.", R.drawable.arduinomkrgsm1400),
        Arduinos("Arduino MKR NB 1500", "Placa con conectividad NB-IoT.", R.drawable.arduinomkrnb1500),
        Arduinos("Arduino MKR VIDOR 4000", "Placa con FPGA integrada.", R.drawable.arduinomkrvidor4000),
        Arduinos("Arduino Nano 33 IoT", "Placa con conectividad WiFi y Bluetooth.", R.drawable.arduinonano33),
        Arduinos("Arduino Nano 33 BLE", "Placa con conectividad Bluetooth de baja energía.", R.drawable.arduinonano33ble),
        Arduinos("Arduino Nano 33 BLE Sense", "Placa con sensores integrados.", R.drawable.arduinonano33blesense),
        Arduinos("Arduino Nano Every", "Versión actualizada de Arduino Nano.", R.drawable.arduinonanoevery),
        Arduinos("Arduino Nano RP2040 Connect", "Placa basada en el chip RP2040 de Raspberry Pi.", R.drawable.arduinonanorp2040connect)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arduino)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_arduino)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = ArduinoAdapter(arduinoList, this)
        recyclerView.adapter = adapter
    }

    override fun onArduinoClick(position: Int) {
        val clickedArduino = arduinoList[position]
        // Abrir la actividad de detalle del Arduino y pasar la información del Arduino seleccionado
        val intent = Intent(this, ArduinoDetailActivity::class.java)
        intent.putExtra("arduino", clickedArduino)
        startActivity(intent)
    }
}
