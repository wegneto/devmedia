package br.com.devmedia.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.devmedia.entitymanager.JPAEntityManager;
import br.com.devmedia.model.ClienteModel;

@Path("cliente")
public class ClienteService {

	private JPAEntityManager jpaEm = new JPAEntityManager();
	private EntityManager em = jpaEm.getEntityManager();

	@GET
	@Path("listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClienteModel> listar() {
		try {
			String query = "select c from ClienteModel c";
			List<ClienteModel> clientes = em.createQuery(query, ClienteModel.class).getResultList();
			em.close();

			return clientes;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/buscar/{id_cliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteModel buscar(@PathParam("id_cliente") int idCliente) {
		try {
			ClienteModel cliente = em.find(ClienteModel.class, idCliente);
			em.close();

			return cliente;
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}

	}

	@POST
	@Path("cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(ClienteModel cliente) {
		try {
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
			em.close();

			return Response.status(200).entity("Cadastro realizado com sucesso!").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Path("alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(ClienteModel cliente) {
		try {
			em.getTransaction().begin();
			em.merge(cliente);
			em.getTransaction().commit();
			em.close();

			return Response.status(200).entity("Cadastro alterado com sucesso!").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/excluir/{id_cliente}")
	public Response excluir(@PathParam("id_cliente") int idCliente) {
		try {
			ClienteModel cliente = em.find(ClienteModel.class, idCliente);

			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
			em.close();

			return Response.status(200).entity("Registro excluído com sucesso!").build();
		} catch (Exception e) {
			throw new WebApplicationException(500);
		}
	}

}
