package uniba.soa.beverageservice;

import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import uniba.soa.beverageservice.services.BeverageService;

@Provider
public class BeverageServiceBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(BeverageService.class).to(BeverageService.class);
	}
}
