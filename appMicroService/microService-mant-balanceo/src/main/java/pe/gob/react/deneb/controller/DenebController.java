package pe.gob.react.deneb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import pe.gob.react.deneb.service.MicroServiceClient;
import pe.gob.react.react.model.Contacto;


//Consume los servicio de microService-mant de forma balanceada
@Api(value="Servicio de Balanceo de Carga",description="Servicio encargado del consumir de forma balanceada los servicios de Contactos")
@RestController
@RequestMapping("deneb/")
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
	 @GetMapping("/getContacto")
	 public Contacto getContactos(){		
		 logger.info(" --> Inicio Consumiendo servicio getContactos ");
		 return microServiceClient.getContactoByID("5b4523bafb6fc043c8cf000a");	
	 }
	 	 
	 
	 @PostMapping("/saveContacto")
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
	 	 
	 @GetMapping("/getContacto/{getID}")
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
	 public  Contacto getContactoByID(@ApiParam(value = "request", required = true) @RequestParam(required=true) String id){		
		 logger.info(" --> Consumiendo servicio getContactoByID ");
		 return microServiceClient.getContactoByID(id);	
	 }
	 
	 
	 @DeleteMapping("/deleteContacto/{getID}")
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
