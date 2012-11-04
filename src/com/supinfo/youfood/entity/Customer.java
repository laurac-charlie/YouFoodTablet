package com.supinfo.youfood.entity;

import java.util.List;

public class Customer {

	private int id;

	private List<Order> orders;

	private Waiter responsableWaiter;
	
	public Customer() {}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Waiter getResponsableWaiter() {
		return responsableWaiter;
	}

	public void setResponsableWaiter(Waiter responsableWaiter) {
		this.responsableWaiter = responsableWaiter;
	}

}