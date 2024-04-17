package com.yamz.infoiot

import ArduinoAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArduinoActivity : AppCompatActivity(), ArduinoAdapter.OnArduinoClickListener {

    private val arduinoList = listOf(
        Arduinos(
            "Arduino Uno",
            "Placa de desarrollo básica. Arduino Uno es una placa de desarrollo que tiene un microcontrolador ATmega328P. Es ideal para proyectos de electrónica y programación básicos.",
            R.drawable.arduinouno
        ),
        Arduinos(
            "Arduino Mega",
            "Placa de desarrollo con más puertos y memoria. Arduino Mega es una placa de desarrollo con un microcontrolador ATmega2560. Ofrece más puertos y memoria que Arduino Uno, lo que la hace adecuada para proyectos más complejos.",
            R.drawable.arduinomega
        ),
        Arduinos(
            "Arduino Nano",
            "Pequeña placa con tamaño reducido. Arduino Nano es una versión compacta de Arduino Uno. Tiene el mismo microcontrolador ATmega328P pero en un factor de forma más pequeño, lo que la hace ideal para proyectos con espacio limitado.",
            R.drawable.arduinonano
        ),
        Arduinos(
            "Arduino Leonardo",
            "Placa con chip ATmega32u4 y USB nativo. Arduino Leonardo es una placa de desarrollo que utiliza el microcontrolador ATmega32u4. Destaca por tener soporte para USB nativo, lo que simplifica la comunicación con la computadora y otros dispositivos.",
            R.drawable.arduinoleonardo
        ),
        Arduinos(
            "Arduino Due",
            "Placa con procesador ARM de 32 bits. Arduino Due es una placa de desarrollo que utiliza un microcontrolador ARM Cortex-M3 de 32 bits. Ofrece un rendimiento superior y es ideal para aplicaciones que requieren más potencia de procesamiento.",
            R.drawable.arduinodue
        ),
        Arduinos(
            "Arduino Pro Mini",
            "Placa compacta diseñada para proyectos permanentes. Arduino Pro Mini es una versión compacta de Arduino Uno. Está diseñada para proyectos permanentes donde el tamaño es crítico y no se necesita la comodidad de un puerto USB integrado.",
            R.drawable.arduinomini
        ),
        Arduinos(
            "Arduino Pro Micro",
            "Placa compacta con chip ATmega32u4. Arduino Pro Micro es similar a Arduino Leonardo pero en un factor de forma más pequeño. Utiliza el mismo microcontrolador ATmega32u4 y ofrece USB nativo para una fácil programación y comunicación.",
            R.drawable.arduinomicro
        ),
        Arduinos(
            "Arduino MKR1000",
            "Placa con conectividad WiFi. Arduino MKR1000 es una placa de desarrollo que ofrece conectividad WiFi integrada. Es ideal para proyectos IoT que requieren conexión a internet de manera inalámbrica.",
            R.drawable.arduinomkr1000
        ),
        Arduinos(
            "Arduino MKR Zero",
            "Placa con procesador SAMD21 de 32 bits. Arduino MKR Zero utiliza un microcontrolador SAMD21 de 32 bits. Ofrece un rendimiento potente y eficiente en energía, lo que lo hace ideal para aplicaciones que requieren bajo consumo de energía.",
            R.drawable.arduinomkrzero
        ),
        Arduinos(
            "Arduino MKR FOX 1200",
            "Placa con conectividad Sigfox. Arduino MKR FOX 1200 es una placa de desarrollo que ofrece conectividad Sigfox integrada. Es ideal para proyectos IoT que requieren una larga duración de la batería y una conexión de largo alcance.",
            R.drawable.arduinomkrfox1200
        ),
        Arduinos(
            "Arduino MKR WAN 1300",
            "Placa con conectividad LoRa. Arduino MKR WAN 1300 es una placa de desarrollo que ofrece conectividad LoRa integrada. Es ideal para proyectos IoT que requieren una conexión de largo alcance y bajo consumo de energía.",
            R.drawable.arduinowan1300
        ),
        Arduinos(
            "Arduino MKR GSM 1400",
            "Placa con conectividad GSM. Arduino MKR GSM 1400 es una placa de desarrollo que ofrece conectividad GSM integrada. Es ideal para proyectos IoT que requieren comunicación celular para enviar y recibir datos.",
            R.drawable.arduinomkrgsm1400
        ),
        Arduinos(
            "Arduino MKR NB 1500",
            "Placa con conectividad NB-IoT. Arduino MKR NB 1500 es una placa de desarrollo que ofrece conectividad NB-IoT integrada. Es ideal para proyectos IoT que requieren una conexión de bajo consumo de energía y de largo alcance.",
            R.drawable.arduinomkrnb1500
        ),
        Arduinos(
            "Arduino MKR VIDOR 4000",
            "Placa con FPGA integrada. Arduino MKR VIDOR 4000 es una placa de desarrollo que incluye una FPGA integrada. Esto permite una mayor flexibilidad y capacidad de procesamiento para proyectos avanzados.",
            R.drawable.arduinomkrvidor4000
        ),
        Arduinos(
            "Arduino Nano 33 IoT",
            "Placa con conectividad WiFi y Bluetooth. Arduino Nano 33 IoT es una placa de desarrollo que ofrece conectividad WiFi y Bluetooth integrada. Es ideal para proyectos IoT que requieren comunicación inalámbrica y bajo consumo de energía.",
            R.drawable.arduinonano33
        ),
        Arduinos(
            "Arduino Nano 33 BLE",
            "Placa con conectividad Bluetooth de baja energía. Arduino Nano 33 BLE es una placa de desarrollo que ofrece conectividad Bluetooth de baja energía integrada. Es ideal para proyectos que requieren comunicación inalámbrica de bajo consumo de energía.",
            R.drawable.arduinonano33ble
        ),
        Arduinos(
            "Arduino Nano 33 BLE Sense",
            "Placa con sensores integrados. Arduino Nano 33 BLE Sense es una placa de desarrollo que incluye sensores integrados como acelerómetro, giroscopio, temperatura, humedad y presión. Es ideal para proyectos que requieren detección de movimiento y ambiente.",
            R.drawable.arduinonano33blesense
        ),
        Arduinos(
            "Arduino Nano Every",
            "Versión actualizada de Arduino Nano. Arduino Nano Every es una versión actualizada de Arduino Nano con un microcontrolador ATmega4809. Ofrece un rendimiento mejorado y es compatible con las librerías y proyectos existentes de Arduino Nano.",
            R.drawable.arduinonanoevery
        ),
        Arduinos(
            "Arduino Nano RP2040 Connect",
            "Placa basada en el chip RP2040 de Raspberry Pi. Arduino Nano RP2040 Connect es una placa de desarrollo que utiliza el chip RP2040 de Raspberry Pi. Ofrece un rendimiento potente y es ideal para proyectos que requieren una capacidad de procesamiento avanzada.",
            R.drawable.arduinonanorp2040connect
        )
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
