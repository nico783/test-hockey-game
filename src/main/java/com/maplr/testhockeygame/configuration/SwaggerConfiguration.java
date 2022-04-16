package com.maplr.testhockeygame.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration.
 * 
 * @author Nicolas Benizri
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    public static final String APP_NAME = "Test Hockey Game";
    public static final String AUTHOR = "Nicolas Benizri";
    public static final String AUTHOR_MAIL = "nico783@hotmail.com";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.maplr.testhockeygame.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(APP_NAME)
                .contact(new Contact(AUTHOR, null, AUTHOR_MAIL))
                .build();
    }
}
