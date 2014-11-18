/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import cdi.CDIServiceLocator;
import repository.AcompanhamentoRepository;
import repository.AgendamentoRepository;
import model.Acompanhamento;
import model.Agendamento;









	@FacesConverter(forClass = Agendamento.class)
	public class ConversorAgendamento implements Converter {

		//@Inject
		private AgendamentoRepository pessoa;
		
		public ConversorAgendamento() {
			pessoa = CDIServiceLocator.getBean(AgendamentoRepository.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Agendamento retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = pessoa.porId(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				
				Agendamento pessoa = (Agendamento) value;
				return pessoa.getId() == null ? null : pessoa.getId().toString();
			}
			
			return "";
		}

	}

