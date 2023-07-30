package com.i2iSystems.SpringClientServer.Configuariton;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Tüm "/api" isteklerini kapsayacak şekilde belirtildi, ihtiyaca göre düzenlenebilir.
                .allowedOrigins("http://127.0.0.1:5501") // İzin verilen origin adresleri
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // İzin verilen HTTP metotları
                .allowCredentials(true) // Credentials (öz geçerlik) izni
                .maxAge(3600); // Max age (saniye cinsinden), tarayıcı tarafından yapılan "preflight" isteklerinin önbellekte tutulma süresi
    }
}