package com.linling.stitch.crawler.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("crawler-api")
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo()).select().paths(PathSelectors.regex("/stitch-crawler/fetch/.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Stitch Crawler Api")
                .description("Stitch Crawler Api for developers")
                .contact(new Contact("ling.lin", "", "linling_tomas@qq.com"))
                .version("1.0.0").build();
    }
}
