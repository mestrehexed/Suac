package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import Filter.FiltroAgendamento;
import jpa.Transactional;
import model.Agendamento;
import service.NegocioException;
public class AgendamentoRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	EntityManager manager;
	
	
	
	// Filtra os dados da Pesquisa da pessoa ref.
		@SuppressWarnings("unchecked")
		public List<Agendamento> filtrados(FiltroAgendamento filtro) {

			Session sessao = manager.unwrap(Session.class);
			Criteria cri = sessao.createCriteria(Agendamento.class);
			
			if(StringUtils.isNotBlank(filtro.getPesquisanome())){
				cri.add(Restrictions.ilike("data", filtro.getPesquisanome(), MatchMode.ANYWHERE  ));
			
			}
			
				return cri.addOrder(Order.asc("data")).list();
			
			}

		

	

	// salva um Objeto
	@Transactional
	public Agendamento guardar(Agendamento pessoa) {
		return manager.merge(pessoa);

	}

	

	@Transactional
	public void remover(Agendamento pessoa) {
		try {
			pessoa = porId(pessoa.getId());
			manager.remove(pessoa);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esse Item não pode ser excluido");
		}
	}

	// Localiza por ID
	public Agendamento porId(Long id) {
		return manager.find(Agendamento.class, id);
	}

}
