package br.com.javamagazine.wsserver.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.javamagazine.wsserver.bean.Message;
import br.com.javamagazine.wsserver.bean.User;
import br.com.javamagazine.wsserver.util.Util;

@Path("wscontroller")
public class WSController {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello World!";
	}

	@PUT
	@Path("message")
	@Consumes(MediaType.APPLICATION_XML)
	public void addMessage(Message msg) {
		Util.add(msg);
	}

	@PUT
	@Path("user")
	@Consumes(MediaType.APPLICATION_XML)
	public void addUser(User user) {
		Util.add(user);
		
		// Adiciona a mensagem indicando que o usuário entrou na sala
		Message msg = new Message();
		msg.setUser("");
		msg.setMessage(user.getName() + " entrou na sala");
		
		Util.add(msg);
		
		System.out.println("Adicionando usuário: " + user);
	}
	
	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		System.out.println("Chamando método getUsuarios()");
		return Util.getUsers();
	}
	
	@GET
	@Path("messages")
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		return Util.getMessages();
	}
	
	@DELETE
	@Path("user")
	@Consumes(MediaType.TEXT_PLAIN)
	public void removeUser(@QueryParam("user") String user) {
		Util.remove(user);
		Message msg = new Message();
		msg.setUser("");
		msg.setMessage(user + " saiu da sala");
		Util.add(msg);
	}
	
	@DELETE
	public void removeAll() {
		Util.removeAll();
	}

}
