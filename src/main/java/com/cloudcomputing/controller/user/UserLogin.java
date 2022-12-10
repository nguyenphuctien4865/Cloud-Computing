package com.cloudcomputing.controller.user;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.services.AccountService;
import utils.ServletUtils;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserHome
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		login(request,response);
	}



	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		AccountService user = new AccountService();
		AccountModel us = user.findbyUsername(username);

		if (us != null) {
			boolean result = (us.getPassword().equals(password) );
			if (result) {
				HttpSession session = request.getSession();
				session.setAttribute("auth", true);
				session.setAttribute("authUser", us);
				// response.addCookie(new Cookie("ecWebAppAuthUser", user.getUsername()));

				String url = (String) session.getAttribute("retUrl");
				if (url == null)
					if(us.getType().equals("student"))
						url = "/UserHome";
					else
						url = "/Admin";
				ServletUtils.redirect(url, request, response);
			} else {
				request.setAttribute("hasError", true);
				request.setAttribute("errorMessage", "Invalid login.");
				ServletUtils.forward("views/index.jsp", request, response);
			}
		} else {
			request.setAttribute("hasError", true);
			request.setAttribute("errorMessage", "Invalid login.");
			ServletUtils.forward("views/index.jsp", request, response);
		}
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("auth", false);
		session.setAttribute("authUser", new AccountModel());

		String url = request.getHeader("referer");
		if (url == null)
			url = "/Home";
		ServletUtils.redirect(url, request, response);
	}
}
