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
public class PessoaRefBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// local de variaveis
	@Inject
	private PessoaRef p;
	@Inject
	private ServicePessoa pessoaservice;
	private String pessoaSelecionado2;

	@Inject
	private FiltroPessoa filtro;

	private PessoaRef pessoaSelecionada;

	private List<PessoaRef> pessoalist2;

	@Inject
	private PessoaRepository pessoarepository;

	public PessoaRefBean() {
		p = new PessoaRef();
		filtro = new FiltroPessoa();

	}

	// Local de Metodos

	public String excluir() {
		pessoarepository.remover(pessoaSelecionada);
		pessoalist2.remove(pessoaSelecionada);
		pessoaSelecionado2 = pessoaSelecionada.getPessoareferencia().toString();
		FacesUtil.addInfoMessage("Pessoa " + pessoaSelecionado2
				+ " excluído com sucesso.");
		return "ExibirPessoaRef.xhtml";
	}

	// persistir pessoa
	public String adcionarPessoa() {

		FacesUtil.addInfoMessage("Pessoa Referência Salva com Sucesso!");
		this.p = pessoaservice.salvar(this.p);
		return "ExibirPessoaRef.xhtml";

	}

	// pesquisar pessoa
	@Inject
	public void pesquisaPessoa() {
		pessoalist2 = pessoarepository.filtrados(filtro);
	}

	// local de Gets e Sets

	public PessoaRef getP() {
		return p;
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

	public ServicePessoa getPessoaservice() {
		return pessoaservice;
	}

	public void setPessoaservice(ServicePessoa pessoaservice) {
		this.pessoaservice = pessoaservice;
	}

	public String getPessoaSelecionado2() {
		return pessoaSelecionado2;
	}

	public void setPessoaSelecionado2(String pessoaSelecionado2) {
		this.pessoaSelecionado2 = pessoaSelecionado2;
	}

	public List<PessoaRef> getPessoalist2() {
		return pessoalist2;
	}

	public void setPessoalist2(List<PessoaRef> pessoalist2) {
		this.pessoalist2 = pessoalist2;
	}

	public PessoaRepository getPessoarepository() {
		return pessoarepository;
	}

	public void setPessoarepository(PessoaRepository pessoarepository) {
		this.pessoarepository = pessoarepository;
	}

	public void setFiltro(FiltroPessoa filtro) {
		this.filtro = filtro;
	}

}
