package uniba.soa.dbhandler.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Beverage {
	private int id;
	private String name;
	private double price;
	private int quantity;
	private boolean inStock;
	private String supplier;
}
