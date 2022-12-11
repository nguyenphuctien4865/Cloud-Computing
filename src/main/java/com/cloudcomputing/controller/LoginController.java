package com.cloudcomputing.controller;

import java.io.IOException;
import com.cloudcomputing.utils.LoginUtil;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.service.AccountService;
import com.cloudcomputing.service.impl.AccountServiceImpl;

@WebServlet(urlPatterns = {"/login", "/LoginController"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static AccountService accountService = new AccountServiceImpl();

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		AccountModel accountModel = null;
		if (LoginUtil.isValidUser(username, password)) {
			accountModel = accountService.searchByUsername(username);
			if (accountModel.getType().equals("admin")) {
				LoginUtil.redirectLogin(request, response, session, accountModel.getAccountID(),
						accountModel.getUsername(), "/admin/user");
			} else {
				LoginUtil.redirectLogin(request, response, session, accountModel.getAccountID(),
						accountModel.getUsername(), "/user/home");
			}

		} else {
			session.setAttribute("error", "User is not found!");
			response.sendRedirect(request.getContextPath() + "/login");
		}

	}

}
