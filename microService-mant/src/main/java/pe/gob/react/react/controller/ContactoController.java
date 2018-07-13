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
	public @ResponseBody List<Contacto> getContacto() {
		return contactoService.listAllContact();
	}
	
	//para actualizar, crear objetos
	@PostMapping("/saveContacto")
	@ApiOperation(value=" registrar contacto",notes="Permite registrar un contacto")
	public @ResponseBody Contacto saveContacto(@Valid @RequestBody Contacto contacto){
		return contactoService.saveContacto(contacto);		
	}
	
	@GetMapping("/getContacto/{getID}")
	@ApiOperation(value=" obtener contacto",notes="Permite obtener un contacto ")
	public @ResponseBody Contacto getContactoByID(@PathVariable(value="getID") String getID){
		return contactoService.getContactoByID(getID);
	}
		
	@DeleteMapping("/deleteContacto/{getID}")
	@ApiOperation(value=" eliminar contacto",notes="Permite eliminar un contacto")
	public @ResponseBody void deleteContactoByID(@PathVariable(value="getID") String getID){	
		contactoService.deleteContactoByID(new Contacto(getID));
	}	
	
}
