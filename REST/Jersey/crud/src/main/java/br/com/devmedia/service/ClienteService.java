package br.com.devmedia.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import br.com.devmedia.entitymanager.JPAEntityManager;
import br.com.devmedia.model.ClienteModel;

@Path("cliente")
public class ClienteService {

	private JPAEntityManager jpaEm = new JPAEntityManager();
	private EntityManager em = jpaEm.getEntityManager();

	@GET
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

}
