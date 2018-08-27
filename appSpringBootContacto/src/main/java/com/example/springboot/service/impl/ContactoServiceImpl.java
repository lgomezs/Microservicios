package com.example.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.model.Contacto;
import com.example.springboot.repository.ContactoRepository;
import com.example.springboot.service.ContactoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class ContactoServiceImpl implements ContactoService{

	@Autowired private ContactoRepository contactoRepository;

	@Override
	public Flux<Contacto> findByNameAndLastName(String name, String lastName) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.findByNameAndLastName(name, lastName);
	}

	@Override
	public Flux<Contacto> saveAll(Iterable<Contacto> entites) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.saveAll(entites);
	}

	@Override
	public Flux<Contacto> findAll() throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.findAll();
	}

	@Override
	public Flux<Contacto> findAllById(Iterable<String> ids) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.findAllById(ids);
	}

	@Override
	public Mono<Contacto> insert(Contacto entity) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.save(entity);
	}

	@Override
	public Mono<Void> delete(Contacto entity) {	
		return contactoRepository.delete(entity);
	}

	@Override
	public Mono<Contacto> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.findById(id);
	}

	@Override
	public Mono<Void> deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.deleteById(id);
	}

	
	@Override
	public Mono<Contacto> update(Contacto entity) throws Exception {
		// TODO Auto-generated method stub
		return contactoRepository.save(entity);
	}
	
}
