package br.com.devmedia.wsclient.controller;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.devmedia.wsclient.bean.Message;
import br.com.devmedia.wsclient.bean.User;
import br.com.devmedia.wsclient.constant.Constantes;
import br.com.devmedia.wsclient.util.Factory;

public class ServiceControl {
	public static String HOST = "";
	public static String PORT = "";

	public static String hello() {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://localhost:8084");
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_HELLO);
		Response response = resourceWebTarget.request(MediaType.TEXT_PLAIN_TYPE).get();
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}

		String output = response.readEntity(String.class);
		return output;
	}

	public static void addMessage(Message msg) {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://" + HOST + ":" + PORT + Constantes.RESOURCE_ROOT);
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_ADD_MESSAGEM);
		resourceWebTarget.request().put(Entity.entity(msg, MediaType.APPLICATION_XML), Response.class);

	}

	public static void addUser(User user) {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://" + HOST + ":" + PORT + Constantes.RESOURCE_ROOT);
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_ADD_USER);
		resourceWebTarget.request().put(Entity.entity(user, MediaType.APPLICATION_XML), Response.class);

	}

	public static void dellUser(String user) {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://" + HOST + ":" + PORT + Constantes.RESOURCE_ROOT);
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_DELL_USER);
		resourceWebTarget.queryParam("user", user).request().delete();
	}

	public static List<User> getUsers() {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://" + HOST + ":" + PORT + Constantes.RESOURCE_ROOT);
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_GET_USERS);
		List<User> usuarios = resourceWebTarget.request().get(new GenericType<List<User>>() {
		});
		return usuarios;
	}

	public static List<Message> getMessages() {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://" + HOST + ":" + PORT + Constantes.RESOURCE_ROOT);
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_GET_MSG);
		List<Message> msgs = resourceWebTarget.request().get(new GenericType<List<Message>>() {
		});
		return msgs;

	}

	public static void removeAll() {
		Client client = Factory.getInstance();
		WebTarget webTarget = client.target("http://" + HOST + ":" + PORT + Constantes.RESOURCE_ROOT);
		WebTarget resourceWebTarget = webTarget.path(Constantes.RESOURCE_DELL_ALL);
		resourceWebTarget.request().delete();

	}
}