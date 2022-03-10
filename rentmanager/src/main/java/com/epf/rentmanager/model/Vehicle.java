package com.epf.rentmanager.model;

public class Vehicle {

	private int idVehicle;
	private String constructeur;
	private int nb_places;

	// constructeurs

	public Vehicle(int idVehicle, String constructeur, int nb_places) {
		super();
		this.idVehicle = idVehicle;
		this.constructeur = constructeur;
		this.nb_places = nb_places;
	}

	public Vehicle() {
		super();
	}

	// getter & setter
	public int getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public int getNb_places() {
		return nb_places;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}

	@Override
	public String toString() {
		return "Vehicle [idVehicle=" + idVehicle + ", contructeur=" + constructeur + ", nb de places=" + nb_places
				+ "]";
	}

}
