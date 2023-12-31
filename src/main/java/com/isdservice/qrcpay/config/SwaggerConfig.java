package com.isdservice.qrcpay.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SecuritySchemes({@SecurityScheme(
//        name= "bearerToken",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer",
//        bearerFormat = "JWT")})
public class SwaggerConfig {
    @Value("${swagger.version}")
    private String version;
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .info(new Info()
                        .title("QRC Checkout App API")
                        .description("API documentation for QRC Checkout App")
                        .version(version));
    }

    @Bean
    public GroupedOpenApi QRCodeEndpoint() {
        return GroupedOpenApi
                .builder()
                .group("qrcode")
                .pathsToMatch("/api/qrcode/**").build();
    }

    @Bean
    public GroupedOpenApi authEndpoint() {
        return GroupedOpenApi
                .builder()
                .group("auth")
                .pathsToMatch("/api/v1/auth/**").build();
    }

    @Bean
    public GroupedOpenApi userEndpoint() {
        return GroupedOpenApi
                .builder()
                .group("user")
                .pathsToMatch("/api/v1/user/**").build();
    }
}
