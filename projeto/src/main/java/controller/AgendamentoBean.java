package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Filter.FiltroAgendamento;
import jsf.FacesUtil;
import repository.AgendamentoRepository;
import model.Agendamento;


@Named
@ViewScoped
public class AgendamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//variaveis
	@Inject
	private Agendamento agendamento;
	
	@Inject
	private AgendamentoRepository reposy;
	
	@Inject
	private FiltroAgendamento filtroagen;
	
	private List<Agendamento> listaagendamento;
	
	
	
	
	
	
	
	
	
	public  AgendamentoBean(){
		agendamento = new Agendamento();
		filtroagen = new FiltroAgendamento();
	}

	
	
	
	
	//metodos
	
	public String salvar(){
		FacesUtil.addInfoMessage("Salvo com Sucesso!");
		reposy.guardar(agendamento);
		return "Agendamento.xhtml";
	
	}
	
	
	public String excluir(){
		FacesUtil.addInfoMessage("Excluido com Sucesso!");
		reposy.remover(agendamento);
		return "Agendamento.xhtml";
		
	}
	
	@Inject
	public void pesquisar(){
		
		listaagendamento = reposy.filtrados(filtroagen);
	}
	
	
	
	
	//gets e sets
	
	

	
	public Agendamento getAgendamento() {
		return agendamento;
	}



	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}





	public AgendamentoRepository getReposy() {
		return reposy;
	}





	public void setReposy(AgendamentoRepository reposy) {
		this.reposy = reposy;
	}





	public FiltroAgendamento getFiltroagen() {
		return filtroagen;
	}





	public void setFiltroagen(FiltroAgendamento filtroagen) {
		this.filtroagen = filtroagen;
	}





	public List<Agendamento> getListaagendamento() {
		return listaagendamento;
	}





	public void setListaagendamento(List<Agendamento> listaagendamento) {
		this.listaagendamento = listaagendamento;
	}
	
	
	
	
	
	

}
