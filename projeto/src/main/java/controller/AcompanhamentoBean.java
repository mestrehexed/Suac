package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import repository.AcompanhamentoRepository;
import model.Acompanhamento;

@Named
@ViewScoped
public class AcompanhamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// local variaveis
	@Inject
	private Acompanhamento acompanhar;
	// lista de parentesco
	private List<String> listgrau;
	private AcompanhamentoRepository reposy;
	private String grau;
	

	
	
	
	
	
	
	
	
	
	// contrutor
	public AcompanhamentoBean() {
		acompanhar = new Acompanhamento();

	}

	@PostConstruct
	public void inicializar() {
		listgrau = new ArrayList<String>();
		listgrau.add("Mãe");
		listgrau.add("Pai");

	}

	
	// local metodos
	
	public void salvar(){
		acompanhar= reposy.guardar(acompanhar);
	}
	
	
	
	
	
	

	// local gets e sets

	public Acompanhamento getAcompanhar() {
		return acompanhar;
	}

	public void setAcompanhar(Acompanhamento acompanhar) {
		this.acompanhar = acompanhar;
	}


	public List<String> getListgrau() {
		return listgrau;
	}

}
