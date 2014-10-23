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

import repository.UsuarioRepository;
import model.Usuario;
import cdi.CDIServiceLocator;




	@FacesConverter(forClass = Usuario.class)
	public class ConversorUsuario implements Converter {

		
		private UsuarioRepository usuario;
		
		public ConversorUsuario() {
		usuario = CDIServiceLocator.getBean(UsuarioRepository.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Usuario retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = usuario.porId(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
		
			if (value != null) {
			
				Usuario usuario = (Usuario) value;
				return usuario.getId() == null ? null : usuario.getId().toString();
		
			}
		
			return "";
		
		}
			
	
}