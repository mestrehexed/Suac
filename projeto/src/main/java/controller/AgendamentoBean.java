package controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Agendamento;


@Named
@ViewScoped
public class AgendamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//variaveis
	@Inject
	private Agendamento agendamento;
	
	
	
	
	
	
	
	
	public  AgendamentoBean(){
		agendamento = new Agendamento();
	}

	
	
	
	
	//metodos
	
	
	
	
	
	
	
	//gets e sets
	
	


	public Agendamento getAgendamento() {
		return agendamento;
	}



	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}
	

}
