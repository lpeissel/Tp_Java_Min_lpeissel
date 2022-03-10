package com.epf.rentmanager.ui.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.epf.rentmanager.exception.DaoException;
import com.epf.rentmanager.exception.ServiceException;
import com.epf.rentmanager.service.ClientService;
import com.epf.rentmanager.service.ReservationService;
import com.epf.rentmanager.service.VehicleService;

@WebServlet("/users/details")
public class DetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	ReservationService reservationService;

	@Autowired
	ClientService clientService;

	@Autowired
	VehicleService vehicleService;

	@Override
	public void init() throws ServletException {
		super.init();
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			String strIdrecup = request.getQueryString();
			strIdrecup = strIdrecup.substring(3);
			int idRecup = Integer.valueOf(strIdrecup);
			request.setAttribute("user", this.clientService.findById(idRecup));
			request.setAttribute("listResaByClientId", this.reservationService.findResaByClientId(idRecup));
			request.setAttribute("countByClientId", this.reservationService.countResaByClientId(idRecup));

		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DaoException e) {
			e.printStackTrace();
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/users/details.jsp").forward(request, response);

	}
}
