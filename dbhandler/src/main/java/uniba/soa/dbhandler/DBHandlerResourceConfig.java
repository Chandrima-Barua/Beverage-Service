package uniba.soa.dbhandler;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import uniba.soa.dbhandler.resources.DBHandlerResource;

@ApplicationPath("/")
public class DBHandlerResourceConfig extends ResourceConfig {

	public DBHandlerResourceConfig() {
		register(JacksonFeature.class);
		register(DBHandlerResource.class);
		register(new DBHandlerBinder());
	}
}