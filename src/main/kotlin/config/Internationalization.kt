package es.unizar.webeng.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.CookieLocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import java.util.Locale
import java.util.TimeZone

/* 
* Configuración de la internacionalización
* Define los beans necesarios para manejar los mensajes en diferentes idiomas
* y para resolver la localización basada en cookies
*/
@Configuration
class Internationalization {

    // Bean para el MessageSource (internacionalización) 
    @Bean
    fun messageSource(): ResourceBundleMessageSource {
        val messageSource = ResourceBundleMessageSource()
        messageSource.setBasename("lang/messages") // Ruta de los archivos de mensajes
        messageSource.setDefaultEncoding("UTF-8")
        messageSource.setDefaultLocale(Locale.ENGLISH) 
        return messageSource
    }

    // Bean para interceptar cambios de idioma 
    @Bean
    fun localeChangeInterceptor(): LocaleChangeInterceptor {
        val localeChangeInterceptor = LocaleChangeInterceptor()
        localeChangeInterceptor.paramName = "lang" // Parámetro para cambiar el idioma
        return localeChangeInterceptor
    }

    // Bean para manejar la localización usando cookies
    @Bean
    fun localeResolver(): LocaleResolver {
        val localeResolver = CookieLocaleResolver()
        localeResolver.setDefaultLocale(Locale.ENGLISH)
        return localeResolver
    }
}