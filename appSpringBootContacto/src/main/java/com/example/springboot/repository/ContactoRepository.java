package com.example.springboot.repository;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Contacto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ContactoRepository extends ReactiveCassandraRepository<Contacto, String> {

		
	@Query("select * from contacto where names=?0 and lastname=?1")
	Flux<Contacto> findByNameAndLastName(String name,String lastName);
}
