package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import jpa.Transactional;
import model.Acompanhamento;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

}
