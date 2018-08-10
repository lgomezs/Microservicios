package pe.gob.react.swagger.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("pe.gob.react.swagger.config")
@SpringBootApplication
//@EnableDiscoveryClient
public class SwaggerCconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerCconfigApplication.class, args);
	}
		
}
