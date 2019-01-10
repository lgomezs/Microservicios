package pe.gob.react.deneb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.gob.react.deneb.service.MicroServiceClient;
import pe.gob.react.react.model.Contacto;


//Consume los servicio de microService-mant de forma balanceada
@RestController
@RequestMapping("deneb/")
@Api(value="Servicio de Contacto",description="Servicio encargado del consumir los servicios de Contactos")
public class DenebController {

	private static Logger logger = LoggerFactory.getLogger(DenebController.class);
	
	
	@Autowired
	private MicroServiceClient microServiceClient;
	
	 @ApiOperation(value=" lista los contactos",notes="lista todos los contactos")
	 @ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Success", response = String.class),
				@ApiResponse(code = 201, message = "Created"), 
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "Unauthorized"), 
				@ApiResponse(code = 403, message = "Forbidden"),
				@ApiResponse(code = 404, message = "Not Found"), 
				@ApiResponse(code = 500, message = "Failure") 
				})
	 public Contacto getContactos(){		
		 logger.info(" --> Inicio Consumiendo servicio getContactos ");
		 return microServiceClient.getContactos();	
	 }
	 	 
	 
	 @ApiOperation(value = "saveContacto", nickname = "saveContacto", response = Contacto.class)
	 @ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Success", response = String.class),
				@ApiResponse(code = 201, message = "Created"), 
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "Unauthorized"), 
				@ApiResponse(code = 403, message = "Forbidden"),
				@ApiResponse(code = 404, message = "Not Found"), 
				@ApiResponse(code = 500, message = "Failure") 
				})
	 public Contacto saveContacto(@ApiParam(value = "request", required = true) @RequestBody(required=true) Contacto contacto){		
		 logger.info(" --> Consumiendo servicio saveContacto ");
		 return microServiceClient.saveContacto(contacto);	
	 }
	 	 
	 @ApiOperation(value = "getContactoByID", nickname = "getContactoByID", response = Contacto.class)
	 @ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Success", response = String.class),
				@ApiResponse(code = 201, message = "Created"), 
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "Unauthorized"), 
				@ApiResponse(code = 403, message = "Forbidden"),
				@ApiResponse(code = 404, message = "Not Found"), 
				@ApiResponse(code = 500, message = "Failure") 
				})
	 public Contacto getContactoByID(@ApiParam(value = "request", required = true) @RequestParam(required=true) String id){		
		 logger.info(" --> Consumiendo servicio getContactoByID ");
		 return microServiceClient.getContactoByID(id);	
	 }
	 
	 
	 @ApiOperation(value = "deleteContactoByID", nickname = "deleteContactoByID", response = Contacto.class)
	 @ApiResponses(value = { 
				@ApiResponse(code = 200, message = "Success", response = String.class),
				@ApiResponse(code = 201, message = "Created"), 
				@ApiResponse(code = 400, message = "Bad Request"),
				@ApiResponse(code = 401, message = "Unauthorized"), 
				@ApiResponse(code = 403, message = "Forbidden"),
				@ApiResponse(code = 404, message = "Not Found"), 
				@ApiResponse(code = 500, message = "Failure") 
				})
	 public  void deleteContactoByID(@ApiParam(value = "request", required = true) @RequestParam(required=true) String id){		
		 logger.info(" --> Consumiendo servicio deleteContactoByID ");
		 microServiceClient.getContactoByID(id);	
	 }
	 
	 
	
}
