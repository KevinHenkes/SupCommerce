package fr.imie.supcommerce.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	@ManyToOne
	@JoinColumn(name="category_fk")
	private Category category;
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
