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
import model.Acompanhamento;









	@FacesConverter(forClass = Acompanhamento.class)
	public class ConversorAcompanhamento implements Converter {

		//@Inject
		private AcompanhamentoRepository pessoa;
		
		public ConversorAcompanhamento() {
			pessoa = CDIServiceLocator.getBean(AcompanhamentoRepository.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Acompanhamento retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = pessoa.porId(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				
				Acompanhamento pessoa = (Acompanhamento) value;
				return pessoa.getId() == null ? null : pessoa.getId().toString();
			}
			
			return "";
		}

	}

