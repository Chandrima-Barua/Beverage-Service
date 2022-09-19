package uniba.soa.beverageservice;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import uniba.soa.beverageservice.resources.BeverageResource;

@ApplicationPath("/")
public class BeverageServiceResourceConfig extends ResourceConfig {

	public BeverageServiceResourceConfig() {
		register(JacksonFeature.class);
		register(BeverageResource.class);
		register(new BeverageServiceBinder());
	}
}