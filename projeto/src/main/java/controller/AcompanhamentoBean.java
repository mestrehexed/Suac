package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import model.Acompanhamento;
import model.GrauParentesco;
import jpa.Transactional;
import jsf.FacesUtil;


@Named
@ViewScoped
public class AcompanhamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//local variaveis
	private Acompanhamento acompanhar;
	EntityManager manager;

	private GrauParentesco grau ;
	private Class<GrauParentesco> listgrau;
	
	
	
	public AcompanhamentoBean(){
		acompanhar= new  Acompanhamento();
		
	}
	
	public void inicializar(){
		
		listgrau = (GrauParentesco.class);
		
		
	}
	
	
	
	
	
	//local metodos
	@Transactional
	public String salvar(){
		
		manager.merge(acompanhar);
		FacesUtil.addInfoMessage("Acompanhamento  Salvo com Sucesso!");
		return "Acompanhamento.xhtml";
	}



	
	
	//local gets e sets
	
	
	public Acompanhamento getAcompanhar() {
		return acompanhar;
	}

	public void setAcompanhar(Acompanhamento acompanhar) {
		this.acompanhar = acompanhar;
	}







	public GrauParentesco getGrau() {
		return grau;	






		
		
	}

	public Class<GrauParentesco> getListgrau() {
		return listgrau;
	}

	





	
	
	
	
	
	
	
	

}
