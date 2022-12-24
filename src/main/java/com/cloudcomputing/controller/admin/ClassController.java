package com.cloudcomputing.controller.admin;

import com.cloudcomputing.models.DaymonModel;
import com.cloudcomputing.models.MonhocModel;
import com.cloudcomputing.services.*;
import com.cloudcomputing.services.impl.DaymonServiceImpl;
import com.cloudcomputing.services.impl.GiangvienServiceImpl;
import com.cloudcomputing.services.impl.LophocphanServiceImpl;
import com.cloudcomputing.services.impl.MonhocServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/class/*")
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final LophocphanService lophocphanService = new LophocphanServiceImpl();
	private static final MonhocService monhocService = new MonhocServiceImpl();
	private static final GiangvienService giangvienService = new GiangvienServiceImpl();
	private static final DaymonService daymonService = new DaymonServiceImpl();

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
		case "/add":
			getAdd(request, response);

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
		case "/add1":
			postAdd1(request, response);

		default:
			break;
		}
	}
	public void getHome (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("class1", lophocphanService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllClass.jsp");
		rd.forward(request, response);
	}
	public void getAdd (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("monhoc", monhocService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/class/classAdd.jsp");
		rd.forward(request, response);
	}
	public void postAdd1 (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maLop = request.getParameter("maLop");
		String loai = request.getParameter("loai");
		String maMH = request.getParameter("maMH");
		request.setAttribute("maLop", maLop);
		request.setAttribute("loai", loai);
		request.setAttribute("maMH", maMH);
		List<DaymonModel> monhoc = daymonService.findByMaMH(maMH);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/class/classAdd2.jsp");
		rd.forward(request, response);
	}

}
