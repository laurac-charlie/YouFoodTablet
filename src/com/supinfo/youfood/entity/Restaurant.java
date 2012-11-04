package com.supinfo.youfood.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

	private int id;
	
	private List<Zone> zones = new ArrayList<Zone>();
	
	private List<Waiter> waiters = new ArrayList<Waiter>();;

	private String name;
	
	private String adress;
	
	private String gerant;
	
	private String description;
	
	private int nbOfSeat;
	
	private Image photo;

	public Restaurant() {}
	
	public Restaurant(String name, String adress, String gerant) {
		this.name = name;
		this.adress = adress;
		this.gerant = gerant;
	}
	
	public Restaurant(String name, String adress, String gerant, int seat) {
		this.name = name;
		this.adress = adress;
		this.gerant = gerant;
		this.nbOfSeat = seat;
	}
	
	public Restaurant(String name, String adress, String gerant, String description, int seat) {
		this.name = name;
		this.adress = adress;
		this.gerant = gerant;
		this.description = description;
		this.nbOfSeat = seat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Zone> getZones() {
		return zones;
	}

	public void setZones(List<Zone> zones) {
		this.zones = zones;
	}

	public List<Waiter> getWaiters() {
		return waiters;
	}

	public void setWaiters(List<Waiter> waiters) {
		this.waiters = waiters;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGerant() {
		return gerant;
	}

	public void setGerant(String gerant) {
		this.gerant = gerant;
	}
	
	public int getNbOfSeat() {
		return nbOfSeat;
	}

	public void setNbOfSeat(int nbOfSeat) {
		this.nbOfSeat = nbOfSeat;
	}

	public Image getPhoto() {
		return photo;
	}

	public void setPhoto(Image photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}