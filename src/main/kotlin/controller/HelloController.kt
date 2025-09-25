package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.apache.tomcat.util.descriptor.LocalResolver
import es.unizar.webeng.hello.service.SaludoServicio
import java.util.Locale
import org.springframework.context.MessageSource
import org.springframework.web.servlet.LocaleResolver
import jakarta.servlet.http.HttpServletRequest

@Controller
class HelloController(
    @param:Value("\${app.message:Hello World}") 
    private val message: String,
    private val saludoServicio: SaludoServicio,
    private val localeResolver: LocaleResolver,
    private val fuenteMensaje: MessageSource

) {
    
    @GetMapping("/")
    fun welcome(
        model: Model,
        @RequestParam(defaultValue = "") name: String,
        request: HttpServletRequest
    ): String {
        val locale = localeResolver.resolveLocale(request)
        val greeting = if (name.isNotBlank()) saludoServicio.generarSaludo(name, locale) else message
        model["message"] = greeting
        model["name"] = name
        model["currentLocale"] = locale.language

        // Agregar mensajes para los botones de cambio de idioma
        model["changeToSpanish"] = fuenteMensaje.getMessage("change_es", null, locale)
        model["changeToFrench"] = fuenteMensaje.getMessage("change_fr", null, locale)
        model["changeToEnglish"] = fuenteMensaje.getMessage("change_en", null, locale)

        return "welcome"
    }
}

@RestController
class HelloApiController(
    private val saludoServicio: SaludoServicio,
    private val localeResolver: LocaleResolver,
    private val fuenteMensaje: MessageSource
) {
    
    @GetMapping("/api/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloApi(
        @RequestParam(defaultValue = "World") name: String,
        request: HttpServletRequest
    ): Map<String, String> {
        val locale = localeResolver.resolveLocale(request)
        val greeting = if (name.isNotBlank()) saludoServicio.generarSaludo(name, locale) else "Hello World"
        
        return mapOf(
            "message" to greeting,
            "timestamp" to java.time.Instant.now().toString()
        )
    }
}
