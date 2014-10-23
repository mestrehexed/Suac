/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.PessoaRef;
import repository.PessoaRepository;
import service.ServicePessoa;
import jsf.FacesUtil;
import Filter.FiltroPessoa;



/**
 *
 * @author Sergio
 */
@ViewScoped
@Named
public class PessoaRefBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//local de variaveis
	@Inject
	private PessoaRef p;
	@Inject
	private ServicePessoa pessoaservice;
	private String pessoaSelecionado2;
	
	@Inject
	private FiltroPessoa filtro;
	
	private PessoaRef pessoaSelecionada;
	private List<PessoaRef> pessoalist;
	
	@Inject
	private PessoaRepository pessoarepository;

	public PessoaRefBean(){
		p = new PessoaRef();
		filtro = new FiltroPessoa();
		
	}
	
	
	
	
	//Local de Metodos
	
	public void excluir(){
		pessoarepository.remover(pessoaSelecionada);
		pessoalist.remove(pessoaSelecionada);
		 pessoaSelecionado2 = pessoaSelecionada.getPessoareferencia().toString();
		FacesUtil.addInfoMessage("Pessoa " + pessoaSelecionado2
				+ " excluído com sucesso.");
	}
	
	
	
	
	// persistir pessoa
	public String adcionarPessoa(){
		
	FacesUtil.addInfoMessage("Pessoa Referência Salva com Sucesso!");
	this.p = pessoaservice.salvar(this.p);
	return "ExibirPessoaRef.xhtml";
	
	}
	
	//pesquisar pessoa
	@Inject
	public void pesquisaPessoa(){
		pessoalist = pessoarepository.filtrados(filtro);
	}
	
	
	
	// local de Gets e Sets

	
	public PessoaRef getP() {
		return p;
	}

	
	
	
	public List<PessoaRef> getPessoalist() {
		return pessoalist;
	}




	public void setP(PessoaRef p) {
		this.p = p;
	}




	public FiltroPessoa getFiltro() {
		return filtro;
	}




	public PessoaRef getPessoaSelecionada() {
		return pessoaSelecionada;
	}




	public void setPessoaSelecionada(PessoaRef pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
    

}
