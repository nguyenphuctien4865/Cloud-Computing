package com.cloudcomputing.controller.admin;

import com.cloudcomputing.services.*;
import com.cloudcomputing.services.impl.LophocphanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/class")
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final LophocphanService lophocphanService = new LophocphanServiceImpl();

    public ClassController() {
        super();
    }

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
		request.setAttribute("class1", lophocphanService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllClass.jsp");
		rd.forward(request, response);
	}

}
