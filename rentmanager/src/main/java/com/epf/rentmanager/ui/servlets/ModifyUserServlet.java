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
import com.epf.rentmanager.model.Client;
import com.epf.rentmanager.service.ClientService;

@WebServlet("/users/modify")
public class ModifyUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	ClientService clientService;

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
			request.setAttribute("user", this.clientService.findById(idRecup));
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/WEB-INF/views/users/modify.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idNull = request.getQueryString();
		String idOk = idNull.substring(3);
		int id = Integer.parseInt(idOk);

		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String birthDate = request.getParameter("birthdate");

		LocalDate birthDatelocal = LocalDate.parse(birthDate);

		Client modifyClient = new Client(id, firstName, lastName, email, birthDatelocal);

		try {

			request.setAttribute("modifyClient", this.clientService.modify(modifyClient));

		} catch (ServiceException e) {

		}

		this.doGet(request, response);
	}
}