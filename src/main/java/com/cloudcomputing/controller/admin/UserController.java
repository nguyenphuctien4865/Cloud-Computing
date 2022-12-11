package com.cloudcomputing.controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.cloudcomputing.models.SinhvienModel;
import com.cloudcomputing.service.SinhvienService;
import com.cloudcomputing.service.impl.SinhvienServiceImpl;


@WebServlet(urlPatterns = {"/admin/user", "/admin/user/edit"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserController() {
        super();

    }
    private final static SinhvienService sinhvienService = new SinhvienServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getServletPath();
		System.out.println(path);
		if (path == null || path.equals("/")) {
			path = "/admin/user/edit/home";
		}
		switch (path) {
		case "/admin/user/edit/home":
			getHome(request, response);
			break;
		case "/admin/user/add":
			{RequestDispatcher rd = request.getRequestDispatcher("/views/admin/userAdd.jsp");
			rd.forward(request, response);}
			break;
		case "/admin/user/edit":
			getEdit(request, response);

		default:
			getHome(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getServletPath();
		switch (path) {
		case "/admin/user/add":
			postAdd(request, response);
			break;
		case "/admin/user/edit":
			postEdit(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/admin");
			break;
		}
	}
	
	public void getHome (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("user", sinhvienService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllUser.jsp");
		rd.forward(request, response);
	}
	public void getEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("id").toString();
		request.setAttribute("user", sinhvienService.findByMaSV(userID));
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/userEdit.jsp");
		rd.forward(request, response);
	}
	public void postAdd (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	}
	public void postEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String maSV = request.getParameter("maSV");
		String hoTen = request.getParameter("hoTen");
		LocalDate __ngaySinh = LocalDate.parse(request.getParameter("ngaySinh"));
//		Date ngaySinh = Date.valueOf(__ngaySinh);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
		Date ngaySinh = null;
		try {
			ngaySinh = (Date) formatter.parse(request.getParameter("ngaySinh"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Integer maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
		Integer accountID = Integer.parseInt(request.getParameter("accountID"));
		HttpSession session = request.getSession();
		session.setAttribute("maSVEdit", maSV);
		sinhvienService.update(new SinhvienModel(maSV, hoTen, ngaySinh, maKhoa, accountID));
		response.sendRedirect(request.getContextPath() + "admin/user");;
	}
}
