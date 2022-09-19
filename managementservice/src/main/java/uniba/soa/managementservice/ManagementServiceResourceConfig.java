package uniba.soa.managementservice;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import uniba.soa.managementservice.resources.ManagementResource;

@ApplicationPath("/")
public class ManagementServiceResourceConfig extends ResourceConfig {

	public ManagementServiceResourceConfig() {
		register(JacksonFeature.class);
		register(ManagementResource.class);
		register(new ManagementServiceBinder());
	}
}