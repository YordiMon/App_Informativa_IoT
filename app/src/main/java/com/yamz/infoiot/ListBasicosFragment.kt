package com.yamz.infoiot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListBasicosFragment : Fragment() {


    class ListBasicosFragment : Fragment() {

        private var wireList: List<ListBasicosFragment> = emptyList()

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val myView = inflater.inflate(R.layout.List_Basicos_Fragment, container, false)

            initData()

            val recyclerView =
                myView.findViewById<RecyclerView>(
                    R.id.ListRecycler
                )
            val adapter = ListAdapter(List)

            val layoutManager = LinearLayoutManager(container?.context)

            recyclerView?.layoutManager = layoutManager
            recyclerView?.adapter = adapter

            return myView
        }

        private fun initData() {
            List = listOf(
                List(
                    1,
                    "machomacho",
                    getString(R.string.maleToMale),
                    getString(R.string.maleToMaleDescription),
                ),
                List(
                    2,
                    "machohembra",
                    "MACHO-HEMBRA",
                    "\n" +
                            "Un cable macho-hembra tiene un conector \"macho\" en un extremo y un conector \"hembra\" en el otro extremo. Se utiliza para conectar dispositivos que tienen diferentes tipos de puertos o conectores, permitiendo la conexión entre ellos.\n" +
                            "\n" +
                            "Por ejemplo, un cable USB macho-hembra se utiliza para conectar un dispositivo USB, como una impresora o una cámara, a un puerto USB de una computadora. El extremo macho del cable se conecta al puerto USB de la computadora, mientras que el extremo hembra se conecta al puerto USB del dispositivo.\n" +
                            "\n" +
                            "Otro ejemplo común es un cable de extensión de auriculares macho-hembra, que se utiliza para extender la longitud de los auriculares. El extremo macho del cable se conecta al conector de los auriculares, mientras que el extremo hembra se utiliza para conectar los auriculares al dispositivo de audio, como un teléfono o una computadora."
                ),
                List(
                    3,
                    "hembrahembra",
                    "HEMBRA-HEMBRA",
                    "Un cable hembra-hembra es un cable que tiene conectores \"hembra\" en ambos extremos. Estos cables se utilizan para conectar dos dispositivos que tienen puertos o conectores del mismo tipo y género. Por lo general, se utilizan en situaciones donde se necesita una extensión o unión directa entre dos cables macho, sin necesidad de adaptadores adicionales.\n" +
                            "\n" +
                            "Por ejemplo, un cable hembra-hembra USB se podría utilizar para conectar dos cables macho USB entre sí para alargar la distancia de conexión sin necesidad de un adaptador o conector adicional. Del mismo modo, un cable hembra-hembra de audio se puede usar para conectar dos cables macho de audio, extendiendo la longitud de la conexión de los dispositivos de audio.\n" +
                            "\n" +
                            "Los cables hembra-hembra son útiles cuando se necesita una conexión directa entre dos cables macho del mismo tipo y género, sin la necesidad de utilizar adaptadores adicionales."
                ),
                List(
                    4,
                    "puente",
                    "PUENTE",
                    "Un cable puente, en el contexto de la electrónica y la informática, es un cable corto que se utiliza para establecer una conexión directa entre dos puntos, como pines, terminales o conectores en un circuito, dispositivo o sistema. Estos cables generalmente tienen conectores idénticos en ambos extremos, y se utilizan para propósitos como la configuración de hardware, la interconexión de componentes dentro de un sistema, o para facilitar pruebas y diagnósticos.\n" +
                            "\n" +
                            "Por ejemplo, en una placa de pruebas o protoboard, un cable puente podría utilizarse para conectar dos puntos de contacto cercanos para establecer una conexión eléctrica temporal. En electrónica, también se utilizan cables puente para conectar los pines de un microcontrolador o un circuito integrado a otros componentes en un circuito.\n" +
                            "\n" +
                            "En resumen, los cables puente son herramientas versátiles y útiles en la electrónica y la informática, utilizados para establecer conexiones temporales o permanentes entre puntos específicos en un circuito o sistema."
                ),
            )
        }
    }
}

