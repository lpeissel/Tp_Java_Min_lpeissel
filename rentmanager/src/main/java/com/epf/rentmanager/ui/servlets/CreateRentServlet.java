package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Reservation;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/rents/create")
public class CreateRentServlet extends HttpServlet {

	@Autowired
	ReservationService newReservationService;

	@Autowired
	VehicleService vehicleService;
	VehicleService newVehicleService;

	@Autowired
	ClientService clientService;
	ClientService newClientService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			request.setAttribute("vehicles", vehicleService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		try {
			request.setAttribute("clients", clientService.findAll());
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/rents/create.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int clientId = Integer.parseInt(request.getParameter("client_id"));
		int vehicleId = Integer.parseInt(request.getParameter("vehicle_id"));

		String startDate = request.getParameter("debut");
		String endDate = request.getParameter("fin");
		LocalDate startDateLocal = LocalDate.parse(startDate);
		LocalDate endDateLocal = LocalDate.parse(endDate);

		Reservation addReservation = new Reservation(0, clientId, vehicleId, startDateLocal, endDateLocal);

		try {
			this.newReservationService.create(addReservation);

		} catch (ServiceException e) {

		}

		this.doGet(request, response);
	}

}
