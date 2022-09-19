package uniba.soa.managementservice;

import com.sun.net.httpserver.HttpServer;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.Properties;

public class ManagementServiceServer {
	private static final Properties properties = Configuration.loadProperties();

	public static void main(String[] args) throws IOException {
		assert properties != null;
		String serverUri = properties.getProperty("serverUri");

		URI baseUri = UriBuilder.fromUri(serverUri).build();
		ResourceConfig config = ResourceConfig.forApplicationClass(ManagementServiceResourceConfig.class);
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
		System.out.println("Server ready to serve your JAX-RS requests...");
	}
}
