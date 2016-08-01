package br.com.javamagazine.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product")
public class ProductService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getSimpleProduct() {
		return "iPad";
	}
	
}
