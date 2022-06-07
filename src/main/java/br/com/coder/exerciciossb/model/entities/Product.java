package br.com.coder.exerciciossb.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@javax.validation.constraints.NotBlank
	private String name;
	private Double price;
	
	@Min(value = 0)
	private Double fullPrice;
	@Min(value = 0)
	@Max(1)
	private Double discount;
	public Product() {
		
	}
	public Product(String name, double fullPrice, Double discount) {
		super();
		this.name = name;
		this.discount = discount;
		this.fullPrice = fullPrice;
	}
	public void applyDiscount() {
		this.price = fullPrice - fullPrice * discount;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getFullPrice() {
		return fullPrice;
	}
	public void setFullPrice(Double fullPrice) {
		this.fullPrice = fullPrice;
	}

}
