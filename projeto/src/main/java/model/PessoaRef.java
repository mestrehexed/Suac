/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table (name="pessoa_ref")
public class PessoaRef implements Serializable{
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Long id;
    @Column 
    private String pessoareferencia;
    @Column 
    private String Apelido;
    @Column 
    private String Nomemae;
    @Column 
    private String nisref;
    @Column 
    private String cpf;
    @Column 
    private String rg;
    @Column 
    private String orgao;
    @Column 
    private String uf;
    @Column 
    private String data;
    // endereço
    @Column 
    private String endereco;
    @Column 
    private String bairro; 
    @Column 
    private String ufendereco;
    @Column 
    private String cep;
    @Column 
    private String municipio;
    @Column 
    private String complemento;
    @Column 
    private String pontoref;
    @Column 
    private String telefone;
    @Column 
    private String Locdomicilio;
    @Column 
    private boolean endabrigo;
    @Column
    private List<Acompanhamento> familias = new ArrayList<>();
    

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getPessoareferencia() {
		return pessoareferencia;
	}

	public void setPessoareferencia(String pessoareferencia) {
		this.pessoareferencia = pessoareferencia;
	}

	public String getApelido() {
		return Apelido;
	}

	public void setApelido(String apelido) {
		Apelido = apelido;
	}

	public String getNomemae() {
		return Nomemae;
	}

	public void setNomemae(String nomemae) {
		Nomemae = nomemae;
	}

	public String getNisref() {
		return nisref;
	}

	public void setNisref(String nisref) {
		this.nisref = nisref;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgao() {
		return orgao;
	}

	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUfendereco() {
		return ufendereco;
	}

	public void setUfendereco(String ufendereco) {
		this.ufendereco = ufendereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getPontoref() {
		return pontoref;
	}

	public void setPontoref(String pontoref) {
		this.pontoref = pontoref;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLocdomicilio() {
		return Locdomicilio;
	}

	public void setLocdomicilio(String locdomicilio) {
		Locdomicilio = locdomicilio;
	}

	public boolean isEndabrigo() {
		return endabrigo;
	}

	public void setEndabrigo(boolean endabrigo) {
		this.endabrigo = endabrigo;
	}


	@OneToMany(mappedBy="pessoaref",cascade = CascadeType.ALL)
	public List<Acompanhamento> getFamilias() {
		return familias;
	}

	public void setFamilias(List<Acompanhamento> familias) {
		this.familias = familias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaRef other = (PessoaRef) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
    


}
