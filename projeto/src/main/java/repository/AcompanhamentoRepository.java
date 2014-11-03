package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import jpa.Transactional;
import model.Acompanhamento;
import model.Usuario;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import service.NegocioException;
import Filter.FiltroAcompanhamento;



public class AcompanhamentoRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;

	// Filtra os dados da Pesquisa da pessoa ref.
	@SuppressWarnings("unchecked")
	public List<Acompanhamento> filtrados(FiltroAcompanhamento filtro) {

		Session sessao = manager.unwrap(Session.class);
		Criteria cri = sessao.createCriteria(Acompanhamento.class);
	
		if(StringUtils.isNotBlank(filtro.getPesquisanome())){
			cri.add(Restrictions.ilike("nome", filtro.getPesquisanome(), MatchMode.ANYWHERE  ));
		
		}	
		
		if(StringUtils.isNotBlank(filtro.getId())){
			cri.add(Restrictions.ilike("parentesco", filtro.getId(), MatchMode.ANYWHERE  ));
		
		}	
		
		return cri.addOrder(Order.asc("nome")).list();

	}

	// salva um Objeto
	@Transactional
	public Acompanhamento guardar(Acompanhamento pessoa) {

		return manager.merge(pessoa);

	}

	@Transactional
	public void remover(Acompanhamento pessoa){
		try{
		pessoa = porId(pessoa.getId()); 
		manager.remove(pessoa);
		manager.flush();
	}catch(PersistenceException e){
			throw new NegocioException("Esse Item não pode ser excluido");
		}
	}
	
//Localiza por ID
	public Acompanhamento porId(Long id) {
		return manager.find(Acompanhamento.class, id);
	}
	
	
}
