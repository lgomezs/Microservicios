package pe.gob.react.react.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.react.react.model.Contacto;
import pe.gob.react.react.repository.ContactoRepository;


@Service
public class ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	public List<Contacto> listAllContact() {	
			return contactoRepository.findAll();				
	}
	
	public Contacto saveContacto(Contacto contacto){
		return  contactoRepository.save(contacto);
	}
	
	public Contacto getContactoByID(String id){
		return contactoRepository.findOne(id);
	}
	
	public void deleteContactoByID(Contacto contacto) {
		contactoRepository.delete(contacto);
	}
}
