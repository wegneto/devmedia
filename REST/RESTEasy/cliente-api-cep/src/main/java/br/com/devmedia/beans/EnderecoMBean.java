package br.com.devmedia.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.devmedia.entidades.Endereco;

@Named
@ViewScoped
public class EnderecoMBean implements Serializable {

	private static final String URL = "http://www.devmedia.com.br/api/cep/service/";
	private static final String CHAVE = "QEJ45ODUDW";

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
		WebTarget target = client.target(URL + "?cep=" + cep + "&chave=" + CHAVE + "&formato=json");

		Response response = target.request().get();
		String json = response.readEntity(String.class);
		response.close();
		
		endereco = new Gson().fromJson(json, Endereco.class);
		
	}

}
