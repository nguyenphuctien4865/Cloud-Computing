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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/DKMH/*")
public class UserDK extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        HttpSession session = req.getSession();
        LocalDate now = LocalDate.now();
        AccountModel us = (AccountModel) session.getAttribute("authUser");
        int [][] tkb = (int[][]) session.getAttribute("tkb");
        if (path == null || path.equals("/")) {
            path = "/Index";
        }
        switch (path) {
                case "/Index":

                    SinhvienService svs = new SinhvienServiceImpl();
                    SinhvienModel s = svs.findByMaSV(us.getUsername());
                    System.out.println(now);
                    MonhocService mh = new MonhocServiceImpl();
                    List<MonhocModel> listMH = mh.findbyCurrentUser(s.getMaKhoa());

                    LophocphanService ltged =new LophocphanServiceImpl();
                    List<LophocphanModel> listTG = ltged.findbymsSV(now,us.getUsername());

                    if (session.getAttribute("cart")==null) {
                        session.setAttribute("cart", listTG);
                    }

                    for (LophocphanModel lopTG:listTG) {
                            String[] tiet = lopTG.getTiet().split(",");
                            for (int i = 0; i < tiet.length; i++){
                                tkb[lopTG.getThu()][Integer.parseInt(tiet[i])] =1;
                            }
                    }


                    session.setAttribute("tkb",tkb);
                    req.setAttribute("listthamgia",listTG);
                    req.setAttribute("listmonhoc", listMH);
                    System.out.println(listMH.size());
                    ServletUtils.forward("/views/user/UserDKMH.jsp", req, resp);
                    break;

                case "/Detail":

                    var maMH = req.getParameter("maMH");
                    System.out.println(maMH);

                    LophocphanService lhp =new LophocphanServiceImpl();

                    List<LophocphanModel> listLHP = lhp.findbyDate(now,maMH);

                    req.setAttribute("lophocphan", listLHP);

                    ServletUtils.forward("/views/user/UserLHP.jsp", req, resp);
                    break;
                case "/Register":
                    var lopID = Integer.parseInt(req.getParameter("maLop"));
                    System.out.println(lopID);
                    System.out.println(us.getUsername());

                    LophocphanService lHP= new LophocphanServiceImpl();
                    LophocphanModel  lopHocPhan= lHP.findByid(lopID);
                    int [][] TKBtg = (int[][]) session.getAttribute("tkb");
                    LopthamgiaService ltg =new LopthamgiaServiceImpl();

                    if (session.getAttribute("cart") == null) {
                        List<LophocphanModel> cart = new ArrayList<LophocphanModel>();
                        cart.add(lopHocPhan);
                        LopthamgiaModel newLtg = new LopthamgiaModel(us.getUsername(),lopID,0.0f);
                        ltg.save(newLtg);
                        session.setAttribute("cart", cart);
                    } else {
                        @SuppressWarnings("unchecked")
						List<LophocphanModel> cart = (List<LophocphanModel>) session.getAttribute("cart");
                        int index = isExisting(lopID, cart);
                        if (index == -1) {

                            boolean temp = true;
                            String[] tiet = lopHocPhan.getTiet().split(",");
                            for (int i = 0 ; i < tiet.length;i++) {
                                if (TKBtg[lopHocPhan.getThu()][Integer.parseInt(tiet[i])] == 1) {
                                    temp = false;
                                    break;
                                }
                            }

                            System.out.println(temp);
                            System.out.println(cart);


                            if (temp) {
                                cart.add(lopHocPhan);
                                LopthamgiaModel newLtg = new LopthamgiaModel(us.getUsername(), lopID, 0.0f);
                                ltg.save(newLtg);
                            }
                        }else {
                            req.setAttribute("hasError", true);
                            req.setAttribute("errorMessage", "Đăng ký không thành công, trùng lớp học");
                        }
                        session.setAttribute("cart", cart);
                    }

                    ServletUtils.redirect("/DKMH/",req,resp);
                    break;
            }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private int isExisting(int id, List<LophocphanModel> cart) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getId()==id) {
                return i;
            }
        }
        return -1;
    }
}
