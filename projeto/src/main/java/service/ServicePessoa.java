package service;

import java.io.Serializable;

import javax.inject.Inject;

import repository.PessoaRepository;
import model.PessoaRef;


public class ServicePessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PessoaRepository pessoarepository;
	
		
	public PessoaRef salvar(PessoaRef pessoa){
	
		return pessoarepository.guardar(pessoa);
		
}

	
}
