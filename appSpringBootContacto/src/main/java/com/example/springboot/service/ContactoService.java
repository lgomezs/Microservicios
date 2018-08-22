package com.example.springboot.service;

import com.example.springboot.model.Contacto;

import reactor.core.publisher.Flux;

public interface ContactoService extends BaseService<Contacto, String> {
	
	Flux<Contacto> findByNameAndLastName(String name,String lastName)throws Exception;	;
	
}
