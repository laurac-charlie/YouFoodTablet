package com.supinfo.youfood.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private String name;

	private List<Meal> meals = new ArrayList<Meal>();
	
	public ProductType() {}

	public ProductType(String name) {
		this.name = name;
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

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

}