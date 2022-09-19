package uniba.soa.managementservice.resources;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uniba.soa.managementservice.dto.BeverageDto;
import uniba.soa.managementservice.models.Beverage;
import uniba.soa.managementservice.services.ManagementService;

@Path("beverages")
public class ManagementResource {
	private final ManagementService managementService;

	@Inject
	public ManagementResource(ManagementService managementService) {
		this.managementService = managementService;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBeverage(@Valid BeverageDto beverageDto) {
		Beverage beverage = managementService.addBeverage(beverageDto);
		return Response.status(Response.Status.CREATED).entity(beverage).build();
	}

	@GET
	@Path("{beverageId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getBeverage(@PathParam("beverageId") final int id) {
		Beverage beverage = managementService.getBeverage(id);
		return Response.ok(beverage).build();
	}

	@PUT
	@Path("{beverageId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response updateBeverage(@PathParam("beverageId") final int id, @Valid BeverageDto beverageDto) {
		Beverage beverage = managementService.updateBeverage(id, beverageDto);
		return Response.ok(beverage).build();
	}

	@DELETE
	@Path("{beverageId}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteBeverage(@PathParam("beverageId") final int id) {
		int status = managementService.deleteBeverage(id);
		return Response.noContent().build();
	}
}
