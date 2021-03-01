package com.hiep.servlet.province;

import com.hiep.dao.ProvinceDao;
import com.hiep.model.Province;
import com.hiep.service.ProvinceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletUpdateProvince", urlPatterns = "/updateProvince")
public class ServletUpdateProvince extends HttpServlet {
    ProvinceService provinceService = new ProvinceService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Province province = new Province(id, name);
            request.setAttribute("message",this.provinceService.update(province.getIdProvince(), province));
            List<Province> listProvince = this.provinceService.getAll();
            request.setAttribute("listProvince",listProvince);
            RequestDispatcher dispatcher = request.getRequestDispatcher("province/listProvince.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


        try {
            int id = Integer.parseInt(request.getParameter("idProvince"));
            Province province = this.provinceService.findById(id);
            request.setAttribute("province", province);
            RequestDispatcher dispatcher = request.getRequestDispatcher("province/updateProvince.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
