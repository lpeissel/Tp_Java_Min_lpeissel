package com.epf.rentmanager.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.dao.VehicleDao;

@Service
public class VehicleService {

	private VehicleDao vehicleDao;

	private VehicleService(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public long create(Vehicle vehicle) throws ServiceException {
		try {
			return this.vehicleDao.create(vehicle);

		} catch (DaoException e) {
			e.printStackTrace();
		}

		return 0;

	}

	public long delete(int idVehicle) throws ServiceException {
		try {
			return this.vehicleDao.delete(idVehicle);

		} catch (DaoException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public Vehicle findById(int id) throws ServiceException {
		// TODO: récupérer un véhicule par son id
		try {
			return this.vehicleDao.findById(id).get();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Vehicle> findAll() throws ServiceException {
		try {
			return this.vehicleDao.findAll();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return null;

	}

	public int count() throws SQLException, DaoException {
		return this.vehicleDao.count();
	}

	public long modify(Vehicle modifyVehicle) throws ServiceException {
		try {
			return this.vehicleDao.modify(modifyVehicle);

		} catch (DaoException e) {
			e.printStackTrace();
		}

		return 0;
	}

}
