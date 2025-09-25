package es.unizar.webeng.hello

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor

@SpringBootApplication
/*
* Configura el interceptor para manejar los cambios de idioma
 */
@ConfigurationPropertiesScan
class Application (
      private val localeChangeInterceptor: LocaleChangeInterceptor
): WebMvcConfigurer {
    
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(localeChangeInterceptor)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
