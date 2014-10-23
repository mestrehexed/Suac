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

import repository.PessoaRepository;
import model.PessoaRef;
import model.Usuario;
import cdi.CDIServiceLocator;




	@FacesConverter(forClass = PessoaRef.class)
	public class ConversorPessoa implements Converter {

		//@Inject
		private PessoaRepository pessoa;
		
		public ConversorPessoa() {
			pessoa = CDIServiceLocator.getBean(PessoaRepository.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			PessoaRef retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = pessoa.porId(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				
				PessoaRef pessoa = (PessoaRef) value;
				return pessoa.getId() == null ? null : pessoa.getId().toString();
			}
			
			return "";
		}

	}

