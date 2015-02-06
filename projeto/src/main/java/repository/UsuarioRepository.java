/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.io.Serializable;
import java.util.List;
import java.util.MissingResourceException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import jpa.Transactional;
import jsf.FacesUtil;
import model.Usuario;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.internal.TwoPhaseLoad;

import service.NegocioException;
import Filter.FiltroUsuario;
import controller.UsuarioBean;

/**
 *
 * @author Sergio
 */

public class UsuarioRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;

	private Usuario u;
	
	// METODOS

	// Localiza por ID
	public Usuario porId(Long id) {
		return manager.find(Usuario.class, id);
	}



	// Localiza Raizes da Classe
	public List<Usuario> raizes() {
		return manager.createQuery("from Usuario", Usuario.class)
				.getResultList();
	}

	// Seleciona Pelo nome da Coluna da tabela
	public Usuario porUsuario(String nome) {

		try {

			return manager
					.createQuery("from Usuario where upper(nome)= :nome",
							Usuario.class)
					.setParameter("nome", nome.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	// salva um Objeto
	@Transactional
	public Usuario guardar(Usuario usuario) {

		return manager.merge(usuario);

	}

	// Filtra os dados da Pesquisa.
	@SuppressWarnings("unchecked")
	public List<Usuario> filtrados(FiltroUsuario filtro) {

		Session sessao = manager.unwrap(Session.class);
		Criteria cri = sessao.createCriteria(Usuario.class);

		if (StringUtils.isNotBlank(filtro.getPesquisanome())) {
			cri.add(Restrictions.ilike("nome", filtro.getPesquisanome(),
					MatchMode.ANYWHERE));

		}

		return cri.addOrder(Order.asc("nome")).list();

	}

	@Transactional
	public void remover(Usuario usuario) {
		try {
			usuario = porId(usuario.getId());
			manager.remove(usuario);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esse Item não pode ser excluido");
		}

	}



	public Usuario porEmail(String email) {
		Usuario usuario = null;
		
		try {
			usuario = this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class)
				.setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// nenhum usuário encontrado com o e-mail informado
		}
		
		return usuario;
	}
	
}



