package controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Acompanhamento;
import jsf.FacesUtil;
import Filter.FiltroAcompanhamento;
import repository.AcompanhamentoRepository;



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
	private String listgrau3;
	// lista da model de acompanhamento
	private List<Acompanhamento> acompanhamento;
	@Inject
	private AcompanhamentoRepository reposy;
	private String grau;
	
	private FiltroAcompanhamento filtro;
	

	
	
	public String excluir(){
		reposy.remover(acompanhar);
		 listgrau3 = acompanhar.getNome().toString();
		FacesUtil.addInfoMessage("Acompanhamento " + listgrau3
				+ " excluído com sucesso.");
		return "Acompanhamento.xhtml";
	}

	// contrutor
	public AcompanhamentoBean() {
		acompanhar = new Acompanhamento();
		filtro = new FiltroAcompanhamento();

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
		listgrau.add("Esposo");
		listgrau.add("Esposa");

	}

	// local metodos

	public String salvar() {
		FacesUtil.addInfoMessage("Pessoa Salva com Sucesso!");
		reposy.guardar1(acompanhar);
		return "Acompanhamento.xhtml";

	}
	
	public String salvar2() {
		FacesUtil.addInfoMessage("Pessoa Salva com Sucesso!");
		reposy.guardar(acompanhar);
		return "Acompanhamento.xhtml";

	}
	


	@Inject
	public void pesquisar() {
		acompanhamento = reposy.filtrados(filtro);
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

	

	public List<Acompanhamento> getAcompanhamento() {
		return acompanhamento;
	}

	public void setAcompanhamento(List<Acompanhamento> acompanhamento) {
		this.acompanhamento = acompanhamento;
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


	public String getListgrau3() {
		return listgrau3;
	}

	public void setListgrau3(String listgrau3) {
		this.listgrau3 = listgrau3;
	}

	
	
	
}
