package com.epf.rentmanager.ui.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.model.Vehicle;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/cars/modify")
public class ModifyCarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	VehicleService vehicleService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO

		String strIdrecup = request.getQueryString();
		strIdrecup = strIdrecup.substring(3);
		int idRecup = Integer.valueOf(strIdrecup);
		try {
			request.setAttribute("car", this.vehicleService.findById(idRecup));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/vehicles/modify.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strIdrecup = request.getQueryString();
		strIdrecup = strIdrecup.substring(3);
		int idRecup = Integer.valueOf(strIdrecup);
		String constructeur = request.getParameter("constructeur");
		int nb_places = Integer.parseInt(request.getParameter("nb_places"));

		Vehicle modifyVehicle = new Vehicle(idRecup, constructeur, nb_places);

		try {

			request.setAttribute("modifyVehicle", this.vehicleService.modify(modifyVehicle));

		} catch (ServiceException e) {

		}

		this.doGet(request, response);
	}
}