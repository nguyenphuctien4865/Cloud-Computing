package com.cloudcomputing.controller;

import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.services.AccountService;
import com.cloudcomputing.services.impl.AccountServiceImpl;
import utils.ServletUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class UserHome
 */
@WebServlet("/UserLogin/*")
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
		String path = request.getPathInfo();
		if (path == null || path.equals("/")) {
			path = "/Index";
		}
		switch (path) {
			case "/Index":
				ServletUtils.forward("/views/index.jsp", request, response);
				break;
			case "/Login":
				login(request, response);
				break;
			default:
				ServletUtils.forward("/views/404.jsp", request, response);
				break;
		}
	}



	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String username = request.getParameter("username");
			String password = request.getParameter("password");

			AccountService user = new AccountServiceImpl();
			AccountModel us = user.searchByUsername(username);

			if (us != null && us.getAccountID()!=0) {
				boolean result = (us.getPassword().equals(password));
				if (result) {
					HttpSession session = request.getSession();
					session.setAttribute("auth", true);
					session.setAttribute("authUser", us);
					// response.addCookie(new Cookie("ecWebAppAuthUser", user.getUsername()));

					String url = (String) session.getAttribute("retUrl");
					if (url == null)
						System.out.println(us.getType());
					if (us.getType().equals("student"))
						url = "/UserHome";
					else
						url = "/admin/user";
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
}
