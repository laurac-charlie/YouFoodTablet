package com.supinfo.youfood.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Menu implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String name;

	private List<Meal> meals = new ArrayList<Meal>();
	
	private Administrator createdBy;

	private Date creationDate ;
	
	private boolean current = false;
	
	public Menu() {}
	
	public Menu(String name) {
		super();
		this.name = name;
	}
	
	public Menu(String name, List<Meal> meals, Administrator createdBy,	Date creationDate) {
		super();
		this.name = name;
		this.meals = meals;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
	}
	
	public Menu(String name, Administrator createdBy, Date creationDate) {
		super();
		this.name = name;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
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
	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}
	
}