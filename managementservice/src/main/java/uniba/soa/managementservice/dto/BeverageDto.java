package uniba.soa.managementservice.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import uniba.soa.managementservice.models.Beverage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BeverageDto {

	@NotNull
	@Size(min = 1, message = "Name should be at least 1 character")
	private String name;

	@DecimalMin(value = "0.01")
	private double price;

	@Min(value = 1)
	private int quantity;

	private boolean inStock;

	@NotNull
	@Size(min = 1, message = "Supplier name should be at least 1 character")
	private String supplier;

	public Beverage unmarshall() {
		return new Beverage(-1, name, price, quantity, inStock, supplier);
	}
}

