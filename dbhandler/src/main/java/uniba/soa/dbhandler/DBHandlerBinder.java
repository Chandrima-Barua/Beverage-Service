package uniba.soa.dbhandler;

import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import uniba.soa.dbhandler.repositories.BeverageRepository;
import uniba.soa.dbhandler.repositories.BeverageRepositoryImpl;
import uniba.soa.dbhandler.services.BeverageService;

@Provider
public class DBHandlerBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind(BeverageService.class).to(BeverageService.class).in(Singleton.class);
		bind(BeverageRepositoryImpl.class).to(BeverageRepository.class).in(Singleton.class);
	}
}
