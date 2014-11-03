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
	@Inject
	private Acompanhamento acompanhar;
	// lista de parentesco
	private List<String> listgrau;
	private List<Acompanhamento> listgrau2;
	private String listgrau3;
	// lista da model de acompanhamento
	private List<Acompanhamento> acompanhamento;
	@Inject
	private AcompanhamentoRepository reposy;
	private String grau;
	@Inject
	private FiltroAcompanhamento filtro;
	@Inject
	private Acompanhamento acomSelecionado;

	
	
	public void excluir(){
		reposy.remover(acomSelecionado);
		listgrau2.remove(acomSelecionado);
		 listgrau3 = acomSelecionado.getNome().toString();
		FacesUtil.addInfoMessage("Acompanhamento " + listgrau3
				+ " excluído com sucesso.");
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

	}

	// local metodos

	public String salvar() {
		FacesUtil.addInfoMessage("Pessoa Salva com Sucesso!");
		acompanhar = reposy.guardar(acompanhar);
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

	public List<Acompanhamento> getAcom() {
		return acompanhamento;
	}

	public void setAcom(List<Acompanhamento> acom) {
		this.acompanhamento = acom;
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



	public Acompanhamento getAcomSelecionado() {
		return acomSelecionado;
	}

	public void setAcomSelecionado(Acompanhamento acomSelecionado) {
		this.acomSelecionado = acomSelecionado;
	}

	public List<Acompanhamento> getListgrau2() {
		return listgrau2;
	}

	

	public String getListgrau3() {
		return listgrau3;
	}

	public void setListgrau3(String listgrau3) {
		this.listgrau3 = listgrau3;
	}

	
	
	
}
