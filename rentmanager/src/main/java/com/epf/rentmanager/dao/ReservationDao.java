package com.epf.rentmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.persistence.ConnectionManager;

@Repository
public class ReservationDao {

	private ReservationDao() {
	}


	private static final String CREATE_RESERVATION_QUERY = "INSERT INTO Reservation(client_id, vehicle_id, debut, fin) VALUES(?, ?, ?, ?);";
	private static final String DELETE_RESERVATION_QUERY = "DELETE FROM Reservation WHERE id=?;";
	private static final String FIND_RESERVATIONS_BY_CLIENT_QUERY = "SELECT id, vehicle_id, debut, fin FROM Reservation WHERE client_id=?;";
	private static final String FIND_RESERVATIONS_BY_VEHICLE_QUERY = "SELECT id, client_id, debut, fin FROM Reservation WHERE vehicle_id=?;";
	private static final String FIND_RESERVATIONS_QUERY = "SELECT id, client_id, vehicle_id, debut, fin FROM Reservation;";
	private static final String COUNT_RESERVATIONS_QUERY = "SELECT COUNT (*) FROM Reservation;";
	private static final String COUNT_BY_ID = "SELECT COUNT(*) FROM Reservation WHERE client_id=?; ";

	public long create(Reservation reservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(CREATE_RESERVATION_QUERY);

			pstmt.setInt(1, reservation.getIdClient());
			pstmt.setInt(2, reservation.getIdVehicule());
			Date addStartDate = Date.valueOf(reservation.getStartDate());
			pstmt.setDate(3, addStartDate);
			Date addEndDate = Date.valueOf(reservation.getEndDate());
			pstmt.setDate(4, addEndDate);

			pstmt.executeUpdate();

			return 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;

	}

	public long delete(int idReservation) throws DaoException {
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(DELETE_RESERVATION_QUERY);

			pstmt.setInt(1, idReservation);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public int countResaByClientId(int clientId) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(COUNT_BY_ID);

		pstmt.setInt(1, clientId);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		int compte = rs.getInt(1);

		return compte;

	}

	public List<Reservation> findResaByClientId(int clientId) throws DaoException {
		List<Reservation> reservations = new ArrayList<Reservation>();

		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_BY_CLIENT_QUERY);
			pstmt.setInt(1, clientId);

			ResultSet rs = pstmt.executeQuery(); // table du résultat SQL avec son pointeur

			while (rs.next()) {
				int id = rs.getInt("id");
				int vehicleId = rs.getInt("vehicle_id");
				LocalDate startDate = rs.getDate("debut").toLocalDate();
				LocalDate endDate = rs.getDate("fin").toLocalDate();

				Reservation reservation = new Reservation(id, clientId, vehicleId, startDate, endDate);
				reservations.add(reservation);
			}

			return reservations;
			// System.out.println(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Reservation> findResaByVehicleId(int vehicleId) throws DaoException {
		List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_BY_VEHICLE_QUERY);

			pstmt.setInt(1, vehicleId);

			ResultSet rs = pstmt.executeQuery(); // table du résultat SQL avec son pointeur

			// rs.next(); //on est sur la première ligne de données, next sert à itérer
			while (rs.next()) {
				int id = rs.getInt("id");
				int clientId = rs.getInt("client_id");
				LocalDate startDate = rs.getDate("debut").toLocalDate();
				LocalDate endDate = rs.getDate("fin").toLocalDate();

				Reservation reservation = new Reservation(id, clientId, vehicleId, startDate, endDate);
				reservations.add(reservation);

			}

			return reservations;
			// System.out.println(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<Reservation> findAll() throws DaoException {
		List<Reservation> reservations = new ArrayList<Reservation>();
		try {
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(FIND_RESERVATIONS_QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int idReservation = rs.getInt("id");
				int idClient = rs.getInt("client_id");
				int idVehicule = rs.getInt("vehicle_id");
				LocalDate startDate = rs.getDate("debut").toLocalDate();
				LocalDate endDate = rs.getDate("fin").toLocalDate();

				Reservation reservation = new Reservation(idReservation, idClient, idVehicule, startDate, endDate);
				reservations.add(reservation);

			}

			return reservations;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public int count() throws SQLException {

		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(COUNT_RESERVATIONS_QUERY);

		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int compte = rs.getInt(1);
		return compte;

	}

}
