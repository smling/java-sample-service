package com.bbpos.tms2.services.sample.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class OpenApiConfiguration {
    @Autowired(required = false)
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-name}") String appName,
                                 @Value("${application-description}") String appDescription) {
        String version = Objects.nonNull(buildProperties) ? buildProperties.getVersion():"";
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicSchema", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                        .title(appName)
                        .version(version)
                        .description(appDescription)
                        .termsOfService("http://swagger.io/terms/")
                        );
    }

}
