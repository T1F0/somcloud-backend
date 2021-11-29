package com.som.springboot.config;

import org.springframework.beans.factory.annotation.Value;
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

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value(value = "true")
    private Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("提供者需求者")
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.som.springboot.controller"))
                .paths(PathSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    @Bean
    public Docket generationApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .groupName("遗传算法")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.som.springboot.generationAlgorithm"))
                .paths(PathSelectors.any())
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("som云项目Swagger接口管理文档")
                .description("综合管理 Swagger API 服务/自定义就好")
                .termsOfServiceUrl("http://swagger.io/")
                .contact(new Contact("janis", "127.0.0.1", "janis@163.com.cn"))
                .version("1.0")
                .build();

    }

}
