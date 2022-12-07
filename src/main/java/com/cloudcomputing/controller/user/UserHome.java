package com.cloudcomputing.controller.user;

import com.cloudcomputing.daos.MonhocDao;
import com.cloudcomputing.daos.impl.MonhocDaoImpl;
import com.cloudcomputing.models.MonhocModel;
import com.cloudcomputing.services.MonhocService;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                MonhocService ms = new MonhocService();
                var msSV = req.getAttribute("msSV");
                List<MonhocModel> list = ms.findAll();
                req.setAttribute("monhoc", list);
                System.out.println(list.size());
                ServletUtils.forward("/views/user/UserHome.jsp", req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
