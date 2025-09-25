# Lab 1 Git Race -- Project Report

## Description of Changes
### Primer Cambio: Implementación 'Time-based Greeting' ###
Para implementar dicha funcionalidad se ha creado una carpeta llamada 'service', en la cuál se encuentra el archivo 'SaludoServicio.kt', encargado de gestionar la lógica necesaria para saludar al usuario según el momento del día. Ademásd e ello también ha sido necesario modificar ligeramente el cotrolador 'HelloController.kt', de manera que el atributo 'mensaje' devuelva el saludo teniendo en cuenta la franja horaria.

### Segundo Cambio: Implementación 'Multi-language Support' ###
Para implementar esta funcionalidad ha sido necesario crear un par de carpetas, para mantener un orden y seguir un estandar dentro del proyecto. 
Se ha creado la carpeta 'lang'-> En ella se han creado los archivos los cuales contienen la traducción de las frases de la aplicación a los distintos idiomas soportados. 
En este caso tenemos:
    - Inglés, cuya traducciónd de mensajes se encuentra en el archivo messages.properties
    - Español, cuya traducciónd de mensajes se encuentra en el archivo messages_es.properties
    - Francés, cuya traducciónd de mensajes se encuentra en el archivo messages_fr.properties

Por otra parte también ha sido necesario crear la carpeta 'config' -> En ella se encuentra el archivo 'Internationalization.kt', donde se imlemente el sistema de internacionalización (i18n) de Spring Boot permitiendo así el soporte multiidioma.
    - MessageSource: Define la fuente de mensajes internacionalizados ubicados en la carpeta 'lang/messages' con codificación UTF-8 e inglés como idioma por defecto
    - LocaleChangeInterceptor: Intercepta peticiones HTTP para detectar cambios de idioma mediante el parámetro lang en la URL
    - CookieLocaleResolver: Gestiona la persistencia de la preferencia de idioma del usuario mediante cookies.

El sistema permite a los usuarios cambiar el idioma de la interfaz de manera dinámica. Los mensajes se almacenan en archivos '.properties' organizados por idioma.
También ha sido necesario modificar eñ archivo 'HelloWorld.kt' para permitir la integración del sistema i18n. Puesto que aunque los beans de internacionalización se defininen en 'Internationalization.kt', se necesita registrar manualmente el interceptor en la cadena de procesamiento de peticiones de Spring MVC(por ello la clase Application implementa WebMvcConfigurer, para poder personalizar la configuración de Spring MVC). De lo contrario el interceptor no se activaría de manera automática para detectar el parámetro ?lang=xx en las URLs.
En último lugar también ha sido necesario realizar cambios en la plantilla '.html' para que soporte los distintos idiomas (añadiendo los mensajes definidos en los archivos .properties, relativos a cada idioma).


**Nota:** [Recurso de como internacionalizar la app](https://www.baeldung.com/spring-boot-internationalization)

## Technical Decisions
Para mantener un orden se ha seguido el estandár de organización por carpetas, según la función de los distintos archivos.

## Learning Outcomes
Con esta tarea he podido tener un acercamiento a SpringBoot y Kotlin, y ver como funcionan ambas a la vez de una manera sinérgica. Además también he aprendido a como internacionalizar gracias a los recursos ofrecidos por SpringBoot.

## AI Disclosure
### AI Tools Used
- [Claude.io](https://www.google.com/search?q=claude+ai&rlz=1C1PRUI_enES1037ES1037&oq=cla&gs_lcrp=EgZjaHJvbWUqDggAEEUYJxg7GIAEGIoFMg4IABBFGCcYOxiABBiKBTIGCAEQRRg5MgwIAhAjGCcYgAQYigUyBggDEEUYPDIGCAQQRRg8MgYIBRBFGEEyBggGEEUYPDIGCAcQRRg80gEIMTY4N2owajeoAgCwAgA&sourceid=chrome&ie=UTF-8)

### AI-Assisted Work
- [Describe what was generated with AI assistance]
AI usada: [Cladue.io](https://www.google.com/search?q=claude+ai&rlz=1C1PRUI_enES1037ES1037&oq=cla&gs_lcrp=EgZjaHJvbWUqDggAEEUYJxg7GIAEGIoFMg4IABBFGCcYOxiABBiKBTIGCAEQRRg5MgwIAhAjGCcYgAQYigUyBggDEEUYPDIGCAQQRRg8MgYIBRBFGEEyBggGEEUYPDIGCAcQRRg80gEIMTY4N2owajeoAgCwAgA&sourceid=chrome&ie=UTF-8)
    -> Este agente de IA ha sido utilizado para agilizar y automatizar el proceso de traduccion de los mensajes de la plantilla html, permitiendome así terminar de manera rápida esa parte de trabajo la cuál meramente mecánica y no necesitaba de ningún tipo de lógica.
- [Percentage of AI-assisted vs. original work]
- [Any modifications made to AI-generated code]

### Original Work
- [Describe work done without AI assistance]
- [Your understanding and learning process]