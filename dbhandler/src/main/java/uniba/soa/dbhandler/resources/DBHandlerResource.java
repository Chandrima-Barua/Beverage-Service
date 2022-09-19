package uniba.soa.dbhandler.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import uniba.soa.dbhandler.models.Beverage;
import uniba.soa.dbhandler.services.BeverageService;

import java.net.URI;
import java.util.List;

@Path("beverages")
public class DBHandlerResource {

	private final BeverageService beverageService;

	@Inject
	public DBHandlerResource(BeverageService beverageService) {
		this.beverageService = beverageService;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Beverage> beverages = this.beverageService.getAll();
		return Response.ok(beverages).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(@Context final UriInfo info, Beverage beverage) {
		this.beverageService.add(beverage);
		return Response.created(URI.create(info.getAbsolutePath() + "/" + beverage.getId())).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id) {
		Beverage beverage = this.beverageService.getById(id);
		return Response.ok(beverage).build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") int id, Beverage beverage) {
		this.beverageService.update(id, beverage);
		return Response.ok(beverage).build();
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id) {
		this.beverageService.delete(id);
		return Response.noContent().build();
	}
}
