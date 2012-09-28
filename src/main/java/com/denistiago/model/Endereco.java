package com.denistiago.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("endereco")
public class Endereco {

	private String logradouro;
	private String bairro;
	private String localidade;
	private String cep;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getLocalidade() {
		return localidade;
	}
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", bairro=" + bairro
				+ ", localidade=" + localidade + ", cep=" + cep + "]";
	}
	

}