package uniba.soa.managementservice.services;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uniba.soa.managementservice.Configuration;
import uniba.soa.managementservice.dto.BeverageDto;
import uniba.soa.managementservice.models.Beverage;

import java.util.Properties;

public class ManagementService {
	private final WebTarget managementDBUri;

	public ManagementService() {
		Properties properties = Configuration.loadProperties();
		assert properties != null;
		String dbUri = properties.getProperty("dbUri");
		managementDBUri = ClientBuilder.newClient().target(dbUri + "/beverages");
	}

	public Beverage addBeverage(BeverageDto beverageDto) {
		Beverage beverage = beverageDto.unmarshall();
		Response response = this.managementDBUri.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(beverage));
		Beverage responseBeverage = response.readEntity(Beverage.class);
		return responseBeverage;
	}

	public Beverage getBeverage(int id) {
		Response response = managementDBUri.path("{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_JSON_TYPE).get();
		Beverage beverage = response.readEntity(Beverage.class);
		return beverage;
	}

	public Beverage updateBeverage(int id, BeverageDto beverageDto) {
		Beverage beverage = beverageDto.unmarshall();
		Response response = this.managementDBUri.path("{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_JSON_TYPE).put(Entity.json(beverage));
		Beverage responseBeverage = response.readEntity(Beverage.class);
		return responseBeverage;
	}

	public int deleteBeverage(int id) {
		Response response = this.managementDBUri.path("{id}").resolveTemplate("id", id).request(MediaType.APPLICATION_JSON_TYPE).delete();
		return response.getStatus();
	}
}
