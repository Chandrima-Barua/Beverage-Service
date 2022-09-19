package uniba.soa.dbhandler.services;

import jakarta.inject.Inject;
import uniba.soa.dbhandler.models.Beverage;
import uniba.soa.dbhandler.repositories.BeverageRepository;

import java.util.List;

public class BeverageService {

	private final BeverageRepository beverageRepository;

	@Inject
	public BeverageService(BeverageRepository beverageRepository) {
		this.beverageRepository = beverageRepository;
	}

	public List<Beverage> getAll() {
		return this.beverageRepository.getAll();
	}

	public Beverage getById(int id) {
		return this.beverageRepository.getById(id);
	}

	public void add(Beverage beverage) {
		this.beverageRepository.add(beverage);
		this.beverageRepository.save();
	}

	public void update(int id, Beverage beverage) {
		this.beverageRepository.update(id, beverage);
		this.beverageRepository.save();
	}

	public void delete(int id) {
		this.beverageRepository.delete(id);
		this.beverageRepository.save();
	}
}
