package pe.gob.react.react.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pe.gob.react.react.model.Contacto;

@Repository
public interface ContactoRepository extends MongoRepository<Contacto, String>{

}
