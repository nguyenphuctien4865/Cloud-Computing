package com.cloudcomputing.controller.admin;


import com.cloudcomputing.models.DaymonModel;
import com.cloudcomputing.models.GiangvienModel;
import com.cloudcomputing.models.MonhocModel;
import com.cloudcomputing.services.DaymonService;
import com.cloudcomputing.services.GiangvienService;
import com.cloudcomputing.services.KhoaService;
import com.cloudcomputing.services.MonhocService;
import com.cloudcomputing.services.impl.DaymonServiceImpl;
import com.cloudcomputing.services.impl.GiangvienServiceImpl;
import com.cloudcomputing.services.impl.KhoaServiceImpl;
import com.cloudcomputing.services.impl.MonhocServiceImpl;

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

@WebServlet("/admin/teacher/*")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static GiangvienService giangvienService = new GiangvienServiceImpl();
	private final static KhoaService khoaService = new KhoaServiceImpl();
	private final static MonhocService monhocService = new MonhocServiceImpl();
	private final static DaymonService daymonService = new DaymonServiceImpl();
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String path = request.getPathInfo();
		if (path == null || path.equals("/")) 	{
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
		if (path == null || path.equals("/")) 	{
			path = "/home";
		}
		switch (path) {
		case "/home":
			getHome(request, response);
			break;
		case "/add":
			try {
				postAdd(request, response);
			} catch (ServletException | IOException | ParseException e) {
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				postEdit(request, response);
			} catch (ServletException | IOException | ParseException e) {
				e.printStackTrace();
			}
		default:
			break;
		}
		
	}
	public void getHome (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("teacher", giangvienService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/findAllTeacher.jsp");
		rd.forward(request, response);
	}
	public void getAdd (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("Khoa", khoaService.findAll());
		request.setAttribute("Monhoc", monhocService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/teacher/teacherAdd.jsp");
		rd.forward(request, response);
	}
	public void postAdd (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		String maGV = request.getParameter("maGV");
		String hoTen = request.getParameter("hoTen");
		String _ngaySinh = request.getParameter("ngaySinh");
		Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(_ngaySinh);
		Integer maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
		String loaiGV = request.getParameter("loaiGV");
		String maMH = request.getParameter("maMH");
		giangvienService.save(new GiangvienModel(maGV, hoTen, ngaySinh, maKhoa, loaiGV));
		daymonService.save(new DaymonModel(maMH, maGV));
		response.sendRedirect(request.getContextPath() + "/admin/teacher");
	}
	public void getEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String maGV = request.getParameter("maGV");
		request.setAttribute("gvEdit", giangvienService.findBymaGV(maGV));
		request.setAttribute("teacherKhoa", khoaService.findBykhoaID(giangvienService.findBymaGV(maGV).getMaKhoa()));
		request.setAttribute("Khoa", khoaService.findAll());
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/teacher/teacherEdit.jsp");
		rd.forward(request, response);
	}
	public void postEdit (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException{
		String maGV = request.getParameter("maGV");
		String hoTen = request.getParameter("hoTen");
		String _ngaySinh = request.getParameter("ngaySinh");
		Date ngaySinh = new SimpleDateFormat("yyyy-MM-dd").parse(_ngaySinh);
		Integer maKhoa = Integer.parseInt(request.getParameter("maKhoa"));
		String loaiGV = request.getParameter("loaiGV");
		
		giangvienService.update(new GiangvienModel(maGV, hoTen, ngaySinh, maKhoa, loaiGV));
		response.sendRedirect(request.getContextPath() + "/admin/teacher");
	}

}
