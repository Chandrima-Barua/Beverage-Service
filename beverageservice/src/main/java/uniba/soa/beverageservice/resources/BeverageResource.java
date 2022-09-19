package uniba.soa.beverageservice.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uniba.soa.beverageservice.models.Beverage;
import uniba.soa.beverageservice.services.BeverageService;

import java.util.List;

@Path("beverages")
public class BeverageResource {

	private final BeverageService beverageService;

	@Inject
	public BeverageResource(BeverageService beverageService) {
		this.beverageService = beverageService;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Beverage> beverages = this.beverageService.getAll();
		return Response.ok(beverages).build();
	}
}
