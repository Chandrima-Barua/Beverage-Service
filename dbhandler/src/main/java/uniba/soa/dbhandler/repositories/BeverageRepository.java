package uniba.soa.dbhandler.repositories;

import uniba.soa.dbhandler.models.Beverage;

import java.util.List;

public interface BeverageRepository {
	List<Beverage> getAll();

	Beverage getById(int id);

	void add(Beverage beverage);

	void update(int id, Beverage beverage);

	void delete(int id);

	boolean exists(int id);

	void save();
}
