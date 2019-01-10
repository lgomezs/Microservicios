package pe.gob.react.deneb.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import pe.gob.react.deneb.service.MicroServiceClient;


@Configuration
class DenebConfig {

	@Bean
	@RefreshScope
	MicroServiceClient sadrClient(){
		return new MicroServiceClient();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
