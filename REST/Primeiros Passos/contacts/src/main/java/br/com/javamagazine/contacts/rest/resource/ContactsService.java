package br.com.javamagazine.contacts.rest.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.javamagazine.contacts.bean.Contact;

@Path("/")
public class ContactsService {

	private static List<Contact> contacts = new ArrayList<Contact>();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{contactId}")
	public Contact getContact(@PathParam("contactId") int id) {
		Contact result = null;

		for (Contact contact : contacts) {
			if (contact.getId() == id) {
				result = contact;
				break;
			}
		}

		if (result == null) {
			throw new WebApplicationException(404);
		}

		return result;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> list() {
		return contacts;
	}

	@GET
	@Path("/find/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Contact> findByNBame(@PathParam("name") String name) {
		List<Contact> result = new ArrayList<Contact>();

		for (Contact contact : contacts) {
			if (contact.getName() != null && contact.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(contact);

			}
		}

		return result;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Contact add(Contact contact) {
		if (contact.getName() == null || contact.getName().trim().equals("")) {
			throw new WebApplicationException(
					Response.status(Response.Status.BAD_REQUEST).entity("O nome do contato é obrigatório").build());
		}

		contacts.add(contact);
		contact.setId(contacts.indexOf(contact) + 1);

		return contact;
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void update(@PathParam("id") int id, Contact contact) {
		contacts.set(id - 1, contact);
		contact.setId(contacts.indexOf(contact) + 1);
	}
	
	@DELETE
	public void delete(@QueryParam("contactId") int id) {
		Contact contact = contacts.get(id - 1);
		contacts.remove(contact);
	}

}
