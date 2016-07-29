package br.com.javamagazine.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.javamagazine.contacts.bean.Contact;

public class ContactsClient {

	// Representa um destino (URL) no servidor que provê o serviço
	private WebTarget baseTarget;

	public ContactsClient(String serviceURL) {
		Client client = ClientBuilder.newClient();
		baseTarget = client.target(serviceURL);
	}

	public List<Contact> findAll() {
		Invocation.Builder invocationBuilder = baseTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro listando contatos");
		}

		return response.readEntity(new GenericType<List<Contact>>() {
		});
	}

	public List<Contact> findByName(String name) {
		WebTarget searchTarget = baseTarget.path("/find/" + name);
		Invocation.Builder invocationBuilder = searchTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro listando contatos");
		}

		return response.readEntity(new GenericType<List<Contact>>() {
		});
	}

	public Contact findById(int id) {
		WebTarget searchTarget = baseTarget.path("/" + id);
		Invocation.Builder invocationBuilder = searchTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro recuperando contato");
		}

		return response.readEntity(Contact.class);
	}

	public Contact add(Contact contact) {
		Invocation.Builder invocationBuilder = baseTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(contact, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro criando contato");
		}

		return response.readEntity(Contact.class);
	}

	public void update(Contact contact) {
		WebTarget updateTarget = baseTarget.path("/" + contact.getId());
		Invocation.Builder invocationBuilder = updateTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.put(Entity.entity(contact, MediaType.APPLICATION_JSON));

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro atualizando contato");
		}
	}

	public void delete(Contact contact) {
		WebTarget deleteTarget = baseTarget.queryParam("contactId", contact.getId());
		Invocation.Builder invocationBuilder = deleteTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.delete();

		if (response.getStatus() != Response.Status.OK.getStatusCode()) {
			throw new RuntimeException("Erro removendo contato");
		}
	}

}
