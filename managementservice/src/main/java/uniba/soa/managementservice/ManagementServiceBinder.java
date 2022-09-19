package uniba.soa.managementservice;

import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import uniba.soa.managementservice.services.ManagementService;


@Provider
public class ManagementServiceBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(ManagementService.class).to(ManagementService.class);
	}
}
