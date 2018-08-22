package com.example.springboot.service;



import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseService<E,ID> {
	
	Flux<E> saveAll(Iterable<E> entites)throws Exception;
	
	Flux<E> findAll()throws Exception;
	
	Flux<E> findAllById(Iterable<ID> ids)throws Exception;
	
	Mono<E> insert(E entity)throws Exception;
	
	Mono<E> update(E entity)throws Exception;
	
	Mono<Void> delete(E entity)throws Exception;
	
	Mono<Void> deleteById(ID id)throws Exception;
		
	Mono<E> findById(ID id)throws Exception;	
}
