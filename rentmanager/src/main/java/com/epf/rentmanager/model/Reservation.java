package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Reservation {

	private int idReservation;
	private int idClient;
	private int idVehicule;
	private LocalDate startDate;
	private LocalDate endDate;

	// constructeurs
	public Reservation(int idReservation, int idClient, int idVehicule, LocalDate startDate, LocalDate endDate) {
		super();
		this.idReservation = idReservation;
		this.idClient = idClient;
		this.idVehicule = idVehicule;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Reservation() {
		super();
	}

	// getters & setters
	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getIdVehicule() {
		return idVehicule;
	}

	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", idClient=" + idClient + ", idVehicle=" + idVehicule
				+ ", Date de debut=" + startDate + ", Date de fin=" + endDate + "]";
	}

}
