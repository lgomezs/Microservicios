package pe.gob.react.deneb.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import pe.gob.react.react.config.ErrorResponse;
import pe.gob.react.react.model.Contacto;

//@Service
@ConfigurationProperties(prefix="microServiceRest.microService")
public class MicroServiceClient {

	private static Logger logger = LoggerFactory.getLogger(MicroServiceClient.class);	
	private String pingUrl;
		
	@Autowired
	private RestTemplate restTemplate;
//
//	@Autowired
//	public MicroServiceClient(RestTemplate restTemplate) {
//		this.restTemplate=restTemplate;	
//	}
	
	
	@HystrixCommand(fallbackMethod="retrieveFallbackGetContactos")
	public List<Contacto> getContactos(){	
		logger.debug("--> getContactos received - id: {} - content: {}");		
		return restTemplate.getForObject(pingUrl + "/getContacto", List.class);				
	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackSaveContactos")
	public Contacto saveContacto(Contacto contacto){		
		return restTemplate.postForObject(pingUrl + "/saveContacto", contacto,Contacto.class);				
	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackGetContacto")
	public Contacto getContactoByID(String id){		
		return restTemplate.getForObject("http://localhost:331/contacto/getContacto/{getID}", Contacto.class, id);	
	}
	
	@HystrixCommand(fallbackMethod="retrieveFallbackDeleteContacto")
	public void deleteContactoByID(String id){		
		restTemplate.delete(pingUrl + "/deleteContacto/{getID}" , id);
	}
	
	
	public ErrorResponse retrieveFallbackDeleteContacto(){
		return new ErrorResponse("Error en eliminar contacto.");
	}
	
	public Contacto retrieveFallbackGetContacto(String id){
		return new Contacto("Error en recuperar contacto.");
	}
	
	public Contacto retrieveFallbackGetContactos(){
		return new Contacto("Error en recupera lista de contactos");
	}
	
	public ErrorResponse retrieveFallbackSaveContactos(){
		return new ErrorResponse("Error al guardar contacto");
	}
	

	public void setPingUrl(String pingUrl) {
		this.pingUrl = pingUrl;
	}
	
	
}