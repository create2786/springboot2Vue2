package com.lyw.springbootadmin.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Swagger2标准接口")
                .apiInfo(apiInfo("SpringBoot集成Swagger构建RESTful APIs", "1.0"))
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lyw.springbootadmin.controller"))
                .paths(PathSelectors.any())
                .build();
    }
    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .title(title)
                .description("https://blog.csdn.net/m0_52818006?type=blog")
                .termsOfServiceUrl("https://blog.csdn.net/m0_52818006?type=blog")
                .contact(new Contact("lyw", "https://blog.csdn.net/m0_52818006?type=blog", "2786034803@qq.com"))
                .version(version)
                .build();
    }
}
