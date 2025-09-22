package es.unizar.webeng.hello.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import es.unizar.webeng.hello.service.SaludoServicio

@Controller
class HelloController(
    @param:Value("\${app.message:Hello World}") 
    private val message: String,
    private val saludoServicio: SaludoServicio
) {
    
    @GetMapping("/")
    fun welcome(
        model: Model,
        @RequestParam(defaultValue = "") name: String
    ): String {
        val greeting = if (name.isNotBlank()) saludoServicio.generarSaludo(name) else message
        model["message"] = greeting
        model["name"] = name
        return "welcome"
    }
}

@RestController
class HelloApiController(
    private val saludoServicio: SaludoServicio
) {
    
    @GetMapping("/api/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun helloApi(
        @RequestParam(defaultValue = "World") name: String
    ): Map<String, String> {
        return mapOf(
            "message" to saludoServicio.generarSaludo(name),
            "timestamp" to java.time.Instant.now().toString()
        )
    }
}
