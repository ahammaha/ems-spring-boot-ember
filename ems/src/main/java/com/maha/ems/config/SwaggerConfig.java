package com.maha.ems.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
	
	private static final String TITLE="EMS Rest API";
	private static final String DESCRIPTION="EMS application to add employees and assign tasks to them";
	private static final String VERSION="1.0";
	private static final Contact CONTACT= new Contact("Maha Shankar", "http://3.16.101.116:4200/employee", "mahalakshmi@outlook.com");
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
		      new HashSet<String>(Arrays.asList("application/json"));
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.version(VERSION)
				.contact(CONTACT)
				.build();
	}
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.maha.ems"))
					.paths(PathSelectors.any())
					.build()
					.produces(DEFAULT_PRODUCES_AND_CONSUMES)
					.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	  }
}
