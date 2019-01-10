package pe.gob.react.react.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import pe.gob.react.react.model.Contacto;
import pe.gob.react.react.service.ContactoService;


@RestController
@RequestMapping(value="/contacto/")
//documentacion swagger
@Api(value="Servicio de Contacto",description="Servicio encargado del mantenimiento de Contactos")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
	@GetMapping("/getContacto")	
	@ApiOperation(value=" lista los contactos",notes="lista todos los contactos")	
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Lista de Contactos obtenidas fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al obtener lista de contactos "),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	public @ResponseBody List<Contacto> getContacto() {
		return contactoService.listAllContact();
	}
	
	//para actualizar, crear objetos
	@PostMapping("/saveContacto")
	@ApiOperation(value=" registrar contacto",notes="Permite registrar un contacto")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Registrar contacto fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al registrar lista de contactos "),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	public @ResponseBody Contacto saveContacto(@Valid @RequestBody Contacto contacto){
		return contactoService.saveContacto(contacto);		
	}
	
	@GetMapping("/getContacto/{getID}")
	@ApiOperation(value=" obtener contacto",notes="Permite obtener un contacto ")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Obtener contacto fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al obtener contacto "),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	public @ResponseBody Contacto getContactoByID(@PathVariable(value="getID") String getID){
		return contactoService.getContactoByID(getID);
	}
		
	@DeleteMapping("/deleteContacto/{getID}")
	@ApiOperation(value=" eliminar contacto",notes="Permite eliminar un contacto")
	@ApiResponses({
	      @ApiResponse(code = 200, message = "Eliminar contacto fue exitoso."),
	      @ApiResponse(code = 500, message = "Error al eliminar contacto "),
	      @ApiResponse(code = 401, message = "No estas autorizado para acceder a los recursos."),
	      @ApiResponse(code = 403, message = "Está prohibido acceder al recurso que intentabas acceder"),
	      @ApiResponse(code = 404, message = "Recurso no encontrado. "),	  
	          })
	public @ResponseBody void deleteContactoByID(@PathVariable(value="getID") String getID){	
		contactoService.deleteContactoByID(new Contacto(getID));
	}	
	
}
