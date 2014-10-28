package Filter;

import java.io.Serializable;

public class FiltroAcompanhamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String pesquisanome;
	private String id;


	public String getPesquisanome() {
		return pesquisanome;
	}


	public void setPesquisanome(String pesquisanome) {
		this.pesquisanome = pesquisanome;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
