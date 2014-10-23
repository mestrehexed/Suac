/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;


import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import jpa.Transactional;
import model.PessoaRef;
import model.Usuario;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import service.NegocioException;
import Filter.FiltroPessoa;

/**
 *
 * @author Sergio
 */

public class PessoaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	//local de variaveis
	@Inject
	private EntityManager manager;
	
	
	
	
	
	
	
	// local para Métodos
	
	
	 @Transactional
		public void remover(PessoaRef pessoa){
			try{
			pessoa = porId(pessoa.getId()); 
			manager.remove(pessoa);
			manager.flush();
			}catch(PersistenceException e){
				throw new NegocioException("Esse Item não pode ser excluido");
			}
			
		}
	
	
	
	//Filtra os dados da Pesquisa.
	@SuppressWarnings("unchecked")
	public List<PessoaRef> filtrados(FiltroPessoa filtro){
		
		Session sessao = manager.unwrap(Session.class);
		Criteria cri = sessao.createCriteria(PessoaRef.class);
		
		if(StringUtils.isNotBlank(filtro.getPesquisanome())){
		cri.add(Restrictions.ilike("pessoareferencia", filtro.getPesquisanome(), MatchMode.ANYWHERE  ));
	
	}
	
		return cri.addOrder(Order.asc("pessoareferencia")).list();
	
	}
	
	
	
	
	//pegar uma pessoa pelo Id.
	public PessoaRef porId(Long id) {
		return manager.find(PessoaRef.class, id);
	}
	
	
	
	
	// salva um Objeto
			@Transactional
			public PessoaRef guardar(PessoaRef pessoa) {
			
				return manager.merge(pessoa);
			
				
			}
	
}