package com.cloudcomputing.controller.user;

import com.cloudcomputing.daos.MonhocDao;
import com.cloudcomputing.daos.impl.MonhocDaoImpl;
import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.models.KhoaModel;
import com.cloudcomputing.models.MonhocModel;
import com.cloudcomputing.models.SinhvienModel;
import com.cloudcomputing.services.KhoaService;
import com.cloudcomputing.services.MonhocService;
import com.cloudcomputing.services.SinhvienService;
import com.cloudcomputing.services.impl.KhoaServiceImpl;
import com.cloudcomputing.services.impl.MonhocServiceImpl;
import com.cloudcomputing.services.impl.SinhvienServiceImpl;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserHome/*")
public class UserHome extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public UserHome(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        if (path == null || path.equals("/")) {
            path = "/Index";
        }

        switch (path) {
            case "/Index":
                MonhocService ms = new MonhocServiceImpl();
                List<MonhocModel> list = ms.findAll();
                req.setAttribute("monhoc", list);
                System.out.println(list.size());
                ServletUtils.forward("/views/user/UserHome.jsp", req, resp);
                break;

            case "/Profile":
                SinhvienService sv = new SinhvienServiceImpl();
                KhoaService kh = new KhoaServiceImpl();
                var msSV = (String) req.getParameter("msSV");
                SinhvienModel sinhvien = sv.findByMaSV(msSV);
                KhoaModel khoa = kh.findBykhoaID(sinhvien.getMaKhoa());
                req.setAttribute("sv", sinhvien);
                req.setAttribute("kh", khoa);
                ServletUtils.forward("/views/user/UserProfile.jsp", req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       logout(req,resp);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("auth", false);
        session.setAttribute("authUser", new AccountModel());

       /* String url = request.getHeader("referer");
        System.out.println(url);*/

        String url = "/UserLogin";
        ServletUtils.redirect(url, request, response);
    }
}
