package com.abc.ecom.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Category_tbl")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	private String categoryNmae;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private Set<Product> products=new HashSet<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryNmae() {
		return categoryNmae;
	}

	public void setCategoryNmae(String categoryNmae) {
		this.categoryNmae = categoryNmae;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
