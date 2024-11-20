package CineCine.Backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Configura CORS para permitir solicitudes desde tu frontend local
        registry.addMapping("/**") // Permite acceso a todos los endpoints
                .allowedOrigins("http://localhost:5173", "https://cinecineapi-production.up.railway.app")  // Permite tus dominios (local y producción)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Permite los métodos que necesitas
                .allowedHeaders("*")  // Permite todos los encabezados
                .allowCredentials(true); // Permite enviar credenciales (si las necesitas)
    }
}