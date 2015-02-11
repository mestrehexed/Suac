/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import model.Usuario;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import jsf.FacesUtil;
import repository.UsuarioRepository;
import service.ServiceUsuario;
import Filter.FiltroUsuario;

/**
 *
 * @author Sérgio
 */
// Para pesquisar,Salvar,Excluir pelo ID aqui só funcionou com View Scoped.
@ViewScoped
@Named
public class UsuarioBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;
	@Inject
	private Usuario u;
	private List<Usuario> usuarioslist;
	private List<Usuario> usuarioslist2;
	@Inject
	private UsuarioRepository usuarioreposy;
	@Inject
	private FiltroUsuario filtro;
	@Inject
	private ServiceUsuario usuarioservice;
	private Usuario usuarioSelecionado;
	private String usuarioSelecionado2;
	private Session sessao;
	private String email;
	private String senha;
	private String recuemail;
	private String recutelefone;
	private static Usuario recuperar;

	// contrutor
	public UsuarioBean() {
		u = new Usuario();
		filtro = new FiltroUsuario();

	}

	// METODOS
	// Para Enviar os Dados Certo Para o Banco Colocar Em Modo @View Scoped

	public String adicionarUsuario() {

		if (u.getSenha().equals(u.getConfirmasenha())) {
			FacesUtil.addInfoMessage("Usuario Salvo com Sucesso!");

			this.u = usuarioservice.salvar(this.u);
		} else {
			FacesUtil.addErrorMessage("Senhas Não Conferem!");
		}

		return "";

	}

	/*@Inject
	public String autentica() {
		sessao = manager.unwrap(Session.class);
		Criteria cri = sessao.createCriteria(Usuario.class);
		cri.add(Restrictions.eq("email", getEmail()))
				.add(Restrictions.eq("senha", getSenha())).uniqueResult();
		usuarioslist2 = cri.list();

		if (usuarioslist2.size() > 0) {
			FacesUtil.addInfoMessage("Bem Vindo!");
			return "Principal.xhtml";
		} else {
			return "//Erro.xhtml";

		}

	}*/

	public String listRecuperarLogin() {
		Session sessao = manager.unwrap(Session.class);
		Criteria cri = sessao.createCriteria(Usuario.class);
		cri.add(Restrictions.eq("email", getRecuemail()));
		cri.add(Restrictions.eq("telefone", getRecutelefone()));
		recuperar = (Usuario) cri.uniqueResult();
		if (recuperar!=null) {

			return "resultadosenha.xhtml";

		} else {
			return "Login.xhtml";
		}

	}

	// para aparecer os dados no DATATABLE utilizando esses filtros precisa
	// colocar o " @INJECT"
	@Inject
	public void pesquisar() {
		usuarioslist = usuarioreposy.filtrados(filtro);
	}

	public void excluir() {
		usuarioreposy.remover(usuarioSelecionado);
		usuarioslist.remove(usuarioSelecionado);
		usuarioSelecionado2 = usuarioSelecionado.getNome().toString();
		FacesUtil.addInfoMessage("Usuario " + usuarioSelecionado2
				+ " excluído com sucesso.");
	}

	// Gets e Sets

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;

	}

	public FiltroUsuario getFiltro() {
		return filtro;
	}

	public List<Usuario> getUsuarioslist() {
		return usuarioslist;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRecuemail() {
		// recuemail = u.getEmail();
		return recuemail;
	}

	public void setRecuemail(String recuemail) {
		this.recuemail = recuemail;
	}

	

	public String getRecutelefone() {
		return recutelefone;
	}

	public void setRecutelefone(String recutelefone) {
		this.recutelefone = recutelefone;
	}

	public Usuario getRecuperar() {
		return recuperar;
	}

	public void setRecuperar(Usuario recuperar) {
		this.recuperar = recuperar;
	}

	public List<Usuario> getUsuarioslist2() {
		return usuarioslist2;
	}

	public void setUsuarioslist2(List<Usuario> usuarioslist2) {
		this.usuarioslist2 = usuarioslist2;
	}

}
