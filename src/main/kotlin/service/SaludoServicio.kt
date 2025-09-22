package es.unizar.webeng.hello.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.stereotype.Service
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.util.*

@Service
class SaludoServicio(
) {
    fun generarSaludo(name: String): String {
        val hora = LocalDateTime.now().hour
        val saludoTipo = when {
                hora < 14 -> "Buenos días"
                hora < 21 -> "Buenas tardes"
                else -> "Buenas noches"
            }
        return if (name == "World") { // Si no hay un nombre específico
            saludoTipo
        } else {
            // Si hay un nombre específico, usamos "Bienvenido, [nombre]!"
            saludoTipo + "," + " " + name + "!"
        }
    }
}