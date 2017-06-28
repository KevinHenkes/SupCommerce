package fr.imie.supcommerce.entity;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2555051498674874014L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
	
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="category")
	private List<Product> products;
	
	public Category() {
		
	}

	public Category(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
