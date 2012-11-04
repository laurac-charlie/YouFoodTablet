package com.supinfo.youfood.entity;

public class Zone {

	private Integer id;
	
	private Waiter assignedWaiter;
	
	private Restaurant theRestaurant;
	
	public Zone(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Waiter getAssignedWaiter() {
		return assignedWaiter;
	}

	public void setAssignedWaiter(Waiter assignedWaiter) {
		this.assignedWaiter = assignedWaiter;
	}

	public Restaurant getTheRestaurant() {
		return theRestaurant;
	}

	public void setTheRestaurant(Restaurant theRestaurant) {
		this.theRestaurant = theRestaurant;
	}


}