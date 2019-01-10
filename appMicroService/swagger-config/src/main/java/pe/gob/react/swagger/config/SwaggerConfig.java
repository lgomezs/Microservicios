package pe.gob.react.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
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

	@Bean
    public Docket sadrApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("REST-REACT")
                .apiInfo(appInfo())
                .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.any())
                    .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false);
    }
	
	/**
	 * About our API
	 * @return
	 */
	private ApiInfo appInfo() {
		//ApiInfo _aApiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl);		
		return new ApiInfo("Spring Boot - Application with React connection to Mongo", 
						"Application Services REST", 
						"1.0", 
						"services", 
						new Contact("Luis Miguel Gomez", "https://github.com/lgomezs", "lmgomez.saavedra@gmail.com"), 
						"Apache License Version 2.0",
						 "https://github.com/lgomezs");		
	}
	
	
}
