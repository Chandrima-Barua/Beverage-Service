package uniba.soa.dbhandler.repositories;

import com.google.gson.Gson;
import uniba.soa.dbhandler.models.Beverage;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BeverageRepositoryImpl implements BeverageRepository {

	private final String filepath;
	private final AtomicInteger counter;
	private final Map<Integer, Beverage> beverages;

	public BeverageRepositoryImpl() {
		String filename = "beverages.json";
		String currentWorkingDirectory = System.getProperty("user.dir");
		filepath = Paths.get(currentWorkingDirectory, "src", "main", "java", "uniba", "soa", "dbhandler", "databases", filename).toString();

		this.beverages = new HashMap<>();
		read();

		int maxId = (this.beverages.size() > 0) ? Collections.max(this.beverages.keySet()) : 0;
		counter = new AtomicInteger(maxId + 1);
	}

	@Override
	public List<Beverage> getAll() {
		return new ArrayList<>(this.beverages.values());
	}

	@Override
	public Beverage getById(int id) {
		return this.beverages.getOrDefault(id, null);
	}

	@Override
	public void add(Beverage beverage) {
		beverage.setId(this.counter.getAndIncrement());
		this.beverages.put(beverage.getId(), beverage);
	}

	@Override
	public void update(int id, Beverage beverage) {
		beverage.setId(id);
		this.beverages.put(beverage.getId(), beverage);
	}

	@Override
	public void delete(int id) {
		this.beverages.remove(id);
	}

	@Override
	public boolean exists(int id) {
		return this.beverages.containsKey(id);
	}

	@Override
	public void save() {
		write();
	}

	private void read() {
		try (FileReader reader = new FileReader(filepath)) {
			Gson gson = new Gson();
			Beverage[] beverageArray = gson.fromJson(reader, Beverage[].class);

			for (Beverage beverage : beverageArray) {
				this.beverages.put(beverage.getId(), beverage);
			}
		} catch (FileNotFoundException exception) {
			System.out.println("File " + filepath + " not found");
		} catch (IOException exception) {
			System.out.println("Something went wrong");
		}
	}

	private void write() {
		try (FileWriter writer = new FileWriter(filepath)) {
			int index = 0;
			Gson gson = new Gson();
			Beverage[] beverageArray = new Beverage[this.beverages.size()];
			for (Beverage beverage : this.beverages.values()) {
				beverageArray[index] = beverage;
			}

			gson.toJson(beverageArray, writer);
		} catch (FileNotFoundException exception) {
			System.out.println("File " + filepath + " not found");
		} catch (IOException exception) {
			System.out.println("Something went wrong");
		}
	}
}
