package com.cloudcomputing.controller.admin;


import com.cloudcomputing.models.KhoaModel;
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
@WebServlet("/admin/major/*")
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
		case "/add":
			getAdd(request,response);
			break;
		case "/edit":
			getEdit(request,response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		case "/add":
			postAdd(request,response);
			break;
		case "/edit":
			postEdit(request,response);
			break;

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public void getHome (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("major", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllMajor.jsp");
		rd.forward(request, response);
	}
	public void getAdd (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/major/majorAdd.jsp");
		rd.forward(request, response);
	}
	public void postAdd (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String tenKhoa = request.getParameter("tenKhoa");
		khoaService.save(new KhoaModel(tenKhoa));
		response.sendRedirect(request.getContextPath() + "/admin/major");
	}
	
	public void getEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer khoaEdit = Integer.parseInt(request.getParameter("id")) ;
		request.setAttribute("khoaEdit", khoaService.findBykhoaID(khoaEdit));
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/major/majorEdit.jsp");
		rd.forward(request, response);
	}
	public void postEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer khoaID = Integer.parseInt(request.getParameter("khoaID"));
		String tenKhoa = request.getParameter("tenKhoa");
		khoaService.update(new KhoaModel(khoaID, tenKhoa));
		response.sendRedirect(request.getContextPath() + "/admin/major");
	}
}
