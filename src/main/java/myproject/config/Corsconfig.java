package myproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class Corsconfig implements WebMvcConfigurer {

   @Override
   public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/api/**")
                    .allowedOrigins("http://localhost:3000")
                    .allowedMethods("GET", "OPTIONS")
                    .allowedHeaders("header1", "header2", "header3")
                    .exposedHeaders("header1", "header2")
                    .allowCredentials(false).maxAge(3600);
   }
 }