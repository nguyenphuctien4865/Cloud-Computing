package com.cloudcomputing.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.service.AccountService;
import com.cloudcomputing.service.impl.AccountServiceImpl;

public class LoginUtil {
	private static AccountService accountService = new AccountServiceImpl();

	public static boolean isValidUser(String username, String password) {
		AccountModel accountmodel = accountService.searchByUsername(username);
		if (accountmodel.getUsername() != null && accountmodel.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public static void redirectLogin(HttpServletRequest req, HttpServletResponse resp, HttpSession session, int accountID,
			String username, String URL) throws IOException {
		resp.sendRedirect(req.getContextPath() + URL);
		session.setAttribute("userID", accountID);
		session.setAttribute("username", username);
		session.setAttribute("usernameInNavbar", username);
		session.setMaxInactiveInterval(60 * 60 * 24);
	}
}
