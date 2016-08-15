package br.com.devmedia.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import br.com.devmedia.entidades.Endereco;

@Named
@ViewScoped
public class EnderecoMBean implements Serializable {

	public static final String URL = "http://www.devmedia.com.br/api/cep/service/";
	public static final String CHAVE = "QEJ45ODUDW";
	
	private Endereco endereco;

	private String cep;

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void buscarEnderecoPorCEP() {
		Client client = ClientBuilder.newClient();
		
		
	}

}
