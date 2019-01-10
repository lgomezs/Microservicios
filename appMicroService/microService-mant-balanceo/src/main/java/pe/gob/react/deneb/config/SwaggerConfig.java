package pe.gob.react.deneb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket sadrApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("deneb-rest")
                .apiInfo(apiInfo())
                .select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                    .paths(PathSelectors.any())
                    .build()
                .pathMapping("/")
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false);
    }
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("microService-mant-balanceo")
                .description("Deneb - para el balanceo de carga a los servicios microService-mant")
                .version("1.0")
                .termsOfServiceUrl("https://es.wikipedia.org/wiki/Sadr")
                .license("Open source licensing")
                .licenseUrl("https://help.github.com/articles/open-source-licensing/")
                .build();
    }
	
}