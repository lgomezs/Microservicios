package pe.gob.react.react.service;

import java.util.List;

import pe.gob.react.react.model.Contacto;


public interface ContactoService {


	public List<Contacto> listAllContact();
	
	public Contacto saveContacto(Contacto contacto);
	
	public Contacto getContactoByID(String id);
	
	public void deleteContactoByID(Contacto contacto) ;
}
