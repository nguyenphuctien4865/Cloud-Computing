package com.cloudcomputing.controller.user;

import com.cloudcomputing.models.*;
import com.cloudcomputing.services.*;
import com.cloudcomputing.services.impl.*;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/DKMH/*")
public class UserDK extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        HttpSession session = req.getSession();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        AccountModel us = (AccountModel) session.getAttribute("authUser");
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
                case "/Index":

                    SinhvienService svs = new SinhvienServiceImpl();
                    SinhvienModel s = svs.findByMaSV(us.getUsername());

                    MonhocService mh = new MonhocServiceImpl();
                    List<MonhocModel> listMH = mh.findbyCurrentUser(s.getMaKhoa());

                    LophocphanService ltged =new LophocphanServiceImpl();
                    List<LophocphanModel> listTG = ltged.findbymsSV(now.toString(),us.getUsername());

                    req.setAttribute("listthamgia",listTG);
                    req.setAttribute("listmonhoc", listMH);
                    System.out.println(listMH.size());
                    ServletUtils.forward("/views/user/UserDKMH.jsp", req, resp);
                    break;

                case "/Detail":

                    var maMH = req.getParameter("maMH");

                    LophocphanService lhp =new LophocphanServiceImpl();

                    List<LophocphanModel> listLHP = lhp.findbyDate(now.toString(),maMH);

                    req.setAttribute("lophocphan", listLHP);

                    ServletUtils.forward("/views/user/UserLHP.jsp", req, resp);
                    break;
                case "/Register":

                    var lopID = Integer.parseInt(req.getParameter("maLop"));
                    HttpSession session1 = req.getSession();

                    LopthamgiaService ltg =new LopthamgiaServiceImpl();
                    LopthamgiaModel newLtg = new LopthamgiaModel(us.getUsername(),lopID,0.0f);
                    ltg.save(newLtg);
                    ServletUtils.redirect("/DKMH/",req,resp);
                    break;
            }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
