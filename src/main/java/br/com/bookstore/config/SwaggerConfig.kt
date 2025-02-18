package br.com.bookstore.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SwaggerConfig {

    @Bean
    open fun openAPI(): OpenAPI {
        return OpenAPI().info(
            Info()
                .title("Bookstore API")
                .description("API documentation for the Bookstore application")
                .version("1.0")
        )
    }
}