package com.epf.rentmanager.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epf.rentmanager.configuration.AppConfiguration;
import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

public class Main {

	public static void main(String[] args) throws ServiceException, DaoException {

		try {

			ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
			ClientService clientService = context.getBean(ClientService.class);
			VehicleService vehicleService = context.getBean(VehicleService.class);
			ReservationService reservationService = context.getBean(ReservationService.class);

//			System.out.println(clientService.findById(2));
//			System.out.println(clientService.findAll());
//			System.out.println(vehicleService.findById(1));
//			System.out.println(vehicleService.findAll());
//			System.out.println(vehicleService.count());
//			System.out.println(reservationService.findAll());
//			System.out.println(reservationService.countResaByClientId(1));
//			System.out.println(reservationService.findResaByVehicleId(2));

		} catch (Exception e) {

		}

	}
}
