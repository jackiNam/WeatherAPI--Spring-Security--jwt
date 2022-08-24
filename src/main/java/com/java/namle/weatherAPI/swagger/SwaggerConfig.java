package com.java.namle.weatherAPI.swagger;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
 public class SwaggerConfig {
     @Bean
     public Docket api() {
         return new Docket(DocumentationType.SWAGGER_2).select()
                                                       .apis(RequestHandlerSelectors.basePackage("com.java.namle.weatherAPI.controller"))
                                                       .paths(PathSelectors.regex("/.*"))
                                                       .build()
                                                       .securitySchemes(Lists.newArrayList(apiKey()))
                                                       .securityContexts(Lists.newArrayList(securityContext()))
                                                       .apiInfo(apiEndPointsInfo());
     }
     @Bean
     SecurityContext securityContext() {
         return SecurityContext.builder()
                 .securityReferences(defaultAuth())
                 .forPaths(PathSelectors.any())
                 .build();
     }
     List<SecurityReference> defaultAuth() {
    	    AuthorizationScope authorizationScope
    	            = new AuthorizationScope("global", "accessEverything");
    	    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
    	    authorizationScopes[0] = authorizationScope;
    	    return Lists.newArrayList(
    	            new SecurityReference("JWT", (springfox.documentation.service.AuthorizationScope[]) authorizationScopes));
    	}

     private ApiInfo apiEndPointsInfo() {
         return new ApiInfoBuilder().title("Spring Boot REST API Login ")
                                    .description("Spring Security")
                                    .license("Apache 2.0")
                                    .contact("namle755@gmail.com")
                                    .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                                    .version("1.0.0")
                                    .build();
     }
     private ApiKey apiKey() {
    	    return new ApiKey("JWT", "Authorization", "header");
    	}
 }

