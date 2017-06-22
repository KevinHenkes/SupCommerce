package fr.imie.supcommerce.model;

import java.util.ArrayList;

public class Product {
	private Long id;
	private String name;
	private String description;
	private Float price;
	
	public Product() {
	}
	
	public Product(ArrayList<String> values) {
        this(values.get(0), values.get(1), Float.valueOf(values.get(2)));
    }
	
	public Product(String name, String description, Float price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name + "<br>Descirption : " + description + "<br>Price : " + price + " euros<br><br>";
	}
}
