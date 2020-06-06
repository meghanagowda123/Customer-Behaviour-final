package com.cts.cba.product;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {

		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.cts.cba"))
				.build().apiInfo(apiDetails());
	}

	public ApiInfo apiDetails() {
		return new ApiInfo("Product",
				"Enables genenerating a quantitative statistical report of purchase pattern of products. Generally deals with list of products.",
				"1.0", "Free To Use",
				new Contact("Rishabh Nag", "http://localhost:9191/product", "Meghana@cognizant.com"), "API License",
				"http://localhost:9191/product", Collections.emptyList());
	}

}
