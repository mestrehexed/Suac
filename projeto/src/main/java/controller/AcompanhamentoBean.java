package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import jsf.FacesUtil;
import Filter.FiltroAcompanhamento;
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
	
	private Acompanhamento acompanhar;
	// lista de parentesco
	private List<String> listgrau;
	//lista da model de acompanhamento
	private List<Acompanhamento> acom;
	@Inject
	private AcompanhamentoRepository reposy;
	private String grau;
	@Inject
	private FiltroAcompanhamento filtro;
	

	
	
	
	
	
	
	
	
	
	// contrutor
	public AcompanhamentoBean() {
		acompanhar = new Acompanhamento();

	}
	
	@PostConstruct
	public void inicializar() {
		listgrau = new ArrayList<String>();
		
		listgrau.add("Mãe");
		listgrau.add("Pai");
		listgrau.add("Filho");
		listgrau.add("Filha");
		listgrau.add("Primo");
		listgrau.add("Prima");
		listgrau.add("Tio");
		listgrau.add("Tia");
		listgrau.add("Irmão");
		listgrau.add("Irmã");
		listgrau.add("Avô");
		listgrau.add("Avó");

	}

	
	// local metodos
	
	public String salvar(){
		FacesUtil.addInfoMessage("Pessoa Salva com Sucesso!");
		acompanhar= reposy.guardar(acompanhar);
		return "Acompanhamento.xhtml";
		
	}
	
	@Inject
	public void pesquisar(){
		acom = reposy.filtrados(filtro);
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
	public List<Acompanhamento> getAcom() {
		return acom;
	}
	public void setAcom(List<Acompanhamento> acom) {
		this.acom = acom;
	}
	public String getGrau() {
		return grau;
	}
	public FiltroAcompanhamento getFiltro() {
		return filtro;
	}
	public void setFiltro(FiltroAcompanhamento filtro) {
		this.filtro = filtro;
	}
	
	
	
	
	
	

}
