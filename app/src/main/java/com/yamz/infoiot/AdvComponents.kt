import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.yamz.infoiot.R

class AdvComponents : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_adv_components, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val iotComponents = arrayOf(
            IotComponent("Sensor de temperatura",
                "El sensor de temperatura es un dispositivo electrónico que mide la temperatura ambiente y proporciona datos precisos en tiempo real. Este sensor es esencial en aplicaciones industriales, comerciales y residenciales. En la industria, se utiliza para monitorear y controlar procesos críticos que requieren condiciones térmicas específicas. En entornos comerciales y residenciales, ayuda a gestionar sistemas de calefacción, ventilación y aire acondicionado para garantizar el confort y la eficiencia energética."),

            IotComponent("Sensor de humedad",
                "El sensor de humedad mide la humedad relativa del aire y es fundamental para el control de la calidad del aire en diversos entornos. En la agricultura, se utiliza en invernaderos para monitorear y regular las condiciones de humedad para optimizar el crecimiento de las plantas. También es esencial en laboratorios y espacios de almacenamiento para mantener condiciones ambientales estables que preserven la integridad de los materiales sensibles."),

            IotComponent("Actuador de luz",
                "El actuador de luz permite controlar la intensidad de la iluminación de manera remota o automática. Este dispositivo es parte integral de los sistemas de iluminación inteligente que ofrecen flexibilidad y eficiencia energética. Puede ser programado para ajustar la intensidad de la luz según las necesidades específicas del usuario, las condiciones ambientales o las preferencias de iluminación. Además, se puede integrar con otros dispositivos inteligentes para crear escenarios de iluminación personalizados y automatizados."),

            IotComponent("Cámara IP",
                "La cámara IP es un sistema de vigilancia avanzado que ofrece monitoreo remoto con alta resolución de imagen. Estas cámaras son ideales para aplicaciones de seguridad en hogares, negocios y espacios públicos. Ofrecen características como detección de movimiento, visión nocturna, y grabación continua o por eventos. Además, permiten el acceso en tiempo real a las imágenes desde cualquier dispositivo con conexión a Internet, lo que proporciona tranquilidad y control total sobre el entorno vigilado."),

            IotComponent("Controlador de puerta",
                "El controlador de puerta electrónica es un dispositivo de seguridad que gestiona el acceso a una entrada mediante métodos de autenticación seguros. Puede ser utilizado en residencias, edificios de oficinas, y instalaciones industriales para proporcionar un nivel adicional de protección. Los controladores de puerta modernos ofrecen múltiples opciones de autenticación como contraseñas, tarjetas RFID, y reconocimiento facial o de huellas dactilares. Esto permite adaptar el nivel de seguridad según las necesidades específicas de cada aplicación.")

        )

        val adapter = IotComponentAdapter(iotComponents) { component ->
            val detailsFago = DetailsFago()
            val bundle = Bundle()
            bundle.putString(DetailsFago.ARG_DESCRIPTION, component.description)
            detailsFago.arguments = bundle

            requireFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, detailsFago)
                .addToBackStack(null)
                .commit()
        }

        recyclerView.adapter = adapter

        return view
    }

    data class IotComponent(val name: String, val description: String)
}
