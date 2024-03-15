package com.atguigu.cloud.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {

    @Bean
    public GroupedOpenApi payApi() {
        return GroupedOpenApi.builder()
                .group("pay")
                .pathsToMatch("/pay/**")
                .build();
    }

    @Bean
    public GroupedOpenApi otherApi() {
        return GroupedOpenApi.builder()
                .group("other")
                .pathsToMatch("/other/**", "/others")
                .build();
    }

    @Bean
    public OpenAPI docsApi() {
        return new OpenAPI()
                .info(new Info().title("cloud2024").version("v1").description("cloud2024 API"))
                .externalDocs(new ExternalDocumentation().description("cloud2024 wiki").url("https://www.baidu.com"));
    }
//    customer
    @Bean
    public GroupedOpenApi customerApi() {
        return GroupedOpenApi.builder()
                .group("customer")
                .pathsToMatch("/customer/**")
                .build();
    }


}
