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
import java.util.Locale
import org.springframework.context.MessageSource

/* Servicio para generar saludos personalizados
* Utiliza la fuente de mensajes para obtener los saludos en el idioma adecuado
*/
@Service
class SaludoServicio(
    private val fuenteMensaje: MessageSource
) {
    fun generarSaludo(name: String, locale: Locale): String {
        val hora = LocalDateTime.now().hour
        val saludoTipo = when {
                hora < 14 -> "good_morning"
                hora < 21 -> "good_afternoon"
                else -> "good_night"
            }
        return if (name == "World") { // Si no hay un nombre específico
            fuenteMensaje.getMessage(saludoTipo, null, locale)
        } else {
            // Si hay un nombre específico, le saludamos por su nombre
            fuenteMensaje.getMessage("${saludoTipo}_con_nombre", arrayOf(name), locale)
        }
    }
}