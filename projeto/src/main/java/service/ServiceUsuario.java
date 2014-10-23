package service;

import java.io.Serializable;
import java.util.MissingResourceException;

import javax.inject.Inject;

import jpa.Transactional;
import repository.UsuarioRepository;
import model.Usuario;

public class ServiceUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioreposy;
	
		
	public Usuario salvar(Usuario usuario){
	
		return usuarioreposy.guardar(usuario);
		
}

	
}
