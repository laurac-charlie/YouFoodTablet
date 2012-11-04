package com.supinfo.youfood.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Meal implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String description;

	private float price;

	private String specificities;

	private List<ProductType> types = new ArrayList<ProductType>();

	private List<Menu> menus = new ArrayList<Menu>();;
	
	private String name;

	private boolean available;

	private Administrator createdBy;

	private Date creationDate;

	private Date lastModification;
	
	public Meal() {}
	
	public Meal(String name , String description, float price, boolean available) {
		this.description = description;
		this.price = price;
		this.name = name;
		this.available = available;
	}
	
	public Meal(String name, String description, float price, boolean available, Administrator createdBy,Date creationDate, Date lastModification) {
		this.description = description;
		this.price = price;
		this.name = name;
		this.available = available;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.lastModification = lastModification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getSpecificities() {
		return specificities;
	}

	public void setSpecificities(String specificities) {
		this.specificities = specificities;
	}

	public List<ProductType> getTypes() {
		return types;
	}

	public void setTypes(List<ProductType> types) {
		this.types = types;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Administrator getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Administrator createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModification() {
		return lastModification;
	}

	public void setLastModification(Date lastModification) {
		this.lastModification = lastModification;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	
}