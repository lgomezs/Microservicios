package com.example.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Contacto;
import com.example.springboot.service.ContactoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value="/contacto/")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
	@GetMapping("/listContacto")
	public Flux<Contacto> findAllContact() throws Exception{		
			return contactoService.findAll();		
	}	
	
	@PostMapping("/saveContacto")
	public Mono<Contacto> saveContacto(@Valid @RequestBody Contacto contacto) throws Exception{
		return contactoService.insert(contacto);		
	}
	
	@PostMapping("/updateContactoByID")
	public Mono<Contacto> updateContactoByID(@Valid @RequestBody Contacto contacto) throws Exception{
			return contactoService.update(contacto);
	}	
	
	@PostMapping("/getContacto/{getID}")
	public Mono<ResponseEntity<Contacto>> getContactoByID(@PathVariable(value="getID") String getID) throws Exception{
		return contactoService.findById(getID).map(
				saveContacto -> ResponseEntity.ok(saveContacto))
				.defaultIfEmpty(ResponseEntity.notFound().build());	
	}
	
	@PostMapping("/deleteContacto/{getID}")
	public ResponseEntity<String> deleteContactoByID(@PathVariable(value="getID") String getID)throws Exception{	
		try {
			contactoService.deleteById(getID).subscribe();
		} catch (Exception e) {
			return new ResponseEntity<>("Fail to delete Contacto!", HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>("Contacto has been deleted!", HttpStatus.OK);
	}		
	
}
