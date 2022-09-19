package uniba.soa.beverageservice.services;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.*;
import uniba.soa.beverageservice.Configuration;
import uniba.soa.beverageservice.models.Beverage;

import java.util.List;
import java.util.Properties;

public class BeverageService {
	private final WebTarget beverageDBUri;

	public BeverageService() {
		Properties properties = Configuration.loadProperties();
		assert properties != null;
		String dbUri = properties.getProperty("dbUri");
		beverageDBUri = ClientBuilder.newClient().target(dbUri + "/beverages");
	}

	public List<Beverage> getAll() {
		Response response = beverageDBUri.request(MediaType.APPLICATION_JSON_TYPE).get();
		List<Beverage> beverages = response.readEntity(new GenericType<List<Beverage>>() {});
		return beverages;
	}
}
