package com.cloudcomputing.controller.admin;


import com.cloudcomputing.services.KhoaService;
import com.cloudcomputing.services.impl.KhoaServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class MajorController
 */
@WebServlet("/admin/major")
public class MajorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MajorController() {
        super();
    }
    private static final KhoaService khoaService = new KhoaServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getPathInfo();
		if (path == null || path.equals("/")) {
			path = "/home";
		}
		switch (path) {
		case "/home":
			getHome(request, response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void getHome (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("major", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllMajor.jsp");
		rd.forward(request, response);
	}

}
