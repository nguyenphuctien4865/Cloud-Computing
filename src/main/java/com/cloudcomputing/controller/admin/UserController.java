package com.cloudcomputing.controller.admin;

import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.models.KhoaModel;
import com.cloudcomputing.models.SinhvienModel;
import com.cloudcomputing.services.AccountService;
import com.cloudcomputing.services.KhoaService;
import com.cloudcomputing.services.SinhvienService;
import com.cloudcomputing.services.impl.AccountServiceImpl;
import com.cloudcomputing.services.impl.KhoaServiceImpl;
import com.cloudcomputing.services.impl.SinhvienServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/admin/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static SinhvienService sinhvienService = new SinhvienServiceImpl();
	private final static KhoaService khoaService = new KhoaServiceImpl();
	private final static AccountService accountService = new AccountServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getPathInfo();
		System.out.println(path);
		if (path == null || path.equals("/")) {
			path = "/home";
		}
		switch (path) {
		case "/home":
			getHome(request, response);
			break;
		case "/edit":
			getEdit(request, response);
			break;
		case "/add":
			getAdd(request, response);
			break;
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
		case "/edit":
			try {
				postEdit(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/add":
			try {
				postAdd(request, response);
			} catch (ServletException | IOException | ParseException e) {
				e.printStackTrace();
			}
		default:
			break;
		}
	}

	public void getHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		request.setAttribute("user", sinhvienService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllUser.jsp");
		rd.forward(request, response);
	}

	public void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String maSVEdit = request.getParameter("maSV");
		Integer svKhoa = Integer.parseInt(request.getParameter("svKhoa"));
		
		System.out.println(maSVEdit);
		request.setAttribute("user", sinhvienService.findByMaSV(maSVEdit));
		request.setAttribute("userKhoa", khoaService.findBykhoaID(svKhoa));
		request.setAttribute("Khoa", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/userEdit.jsp");
		rd.forward(request, response);
	}

	public void postEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ParseException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String _maSV = request.getParameter("maSV");
		String hoTen = request.getParameter("hoTen").toString();
		String _ngaySinh = request.getParameter("ngaySinh");
		Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(_ngaySinh);
		Integer maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
		Integer accountID = Integer.parseInt(request.getParameter("accountID"));
		sinhvienService.update(new SinhvienModel(_maSV, hoTen, ngaySinh, maKhoa, accountID));
		response.sendRedirect(request.getContextPath() + "/admin/user");
	}

	public void getAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("Khoa", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/user/userAdd.jsp");
		rd.forward(request, response);
	}
	public void postAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("maSV");
		String password = request.getParameter("password");
		String type = "student";
		accountService.save(new AccountModel(username, password, type));
		AccountModel curr = accountService.searchByUsername(username);
		String hoTen = request.getParameter("hoTen");
		String _ngaySinh = request.getParameter("ngaySinh");
		Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(_ngaySinh);
		Integer maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
		Integer accountID = curr.getAccountID();
		sinhvienService.save(new SinhvienModel(username, hoTen, ngaySinh, maKhoa, accountID));
		response.sendRedirect(request.getContextPath() + "/admin/user");
	}
}
