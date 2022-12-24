package com.cloudcomputing.controller.admin;

import com.cloudcomputing.models.MonhocModel;
import com.cloudcomputing.services.KhoaService;
import com.cloudcomputing.services.MonhocService;
import com.cloudcomputing.services.impl.KhoaServiceImpl;
import com.cloudcomputing.services.impl.MonhocServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/admin/subject/*")
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubjectController() {
		super();
	}

	private static final MonhocService monhocService = new MonhocServiceImpl();
	private static final KhoaService khoaService = new KhoaServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			getAdd(request, response);
			break;
		case "/edit":
			getEdit(request, response);

		default:
			break;
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			postAdd(request, response);
			break;
		case "/edit":
			postEdit(request, response);

		default:
			break;
		}
	}

	public void getHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("subject", monhocService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllSubject.jsp");
		rd.forward(request, response);
	}

	public void getAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("Khoa", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/subject/subjectAdd.jsp");
		rd.forward(request, response);
	}

	public void postAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maMH = request.getParameter("maMH");
		String tenMH = request.getParameter("tenMH");
		String loai = request.getParameter("loai");
		Integer soTC = Integer.parseInt(request.getParameter("soTC"));
		Integer khoaID = Integer.parseInt(request.getParameter("khoaID"));
		monhocService.save(new MonhocModel(maMH, tenMH, loai, soTC, khoaID));
		response.sendRedirect(request.getContextPath() + "/admin/subject");
	}

	public void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("monKhoa", khoaService.findBykhoaID(Integer.parseInt(request.getParameter("khoa"))));
		request.setAttribute("monEdit", monhocService.findByMaMH(request.getParameter("id")));
		request.setAttribute("Khoa", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/subject/subjectEdit.jsp");
		rd.forward(request, response);
	}

	public void postEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maMH = request.getParameter("maMH");
		String tenMH = request.getParameter("tenMH");
		String loai = request.getParameter("loai");
		Integer soTC = Integer.parseInt(request.getParameter("soTC"));
		Integer khoaID = Integer.parseInt(request.getParameter("khoaID"));
		monhocService.update(new MonhocModel(maMH, tenMH, loai, soTC, khoaID));
		response.sendRedirect(request.getContextPath() + "/admin/subject");
	}

}
