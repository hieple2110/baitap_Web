package com.hiep.servlet.province;

import com.hiep.dao.MissDao;
import com.hiep.dao.ProvinceDao;
import com.hiep.service.MissService;
import com.hiep.service.ProvinceService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteProvince", urlPatterns = "/deleteProvince")
public class ServletDeleteProvince extends HttpServlet {
    ProvinceService provinceService = new ProvinceService();
    MissService missService = new MissService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            this.missService.delete_miss_province(id);
            this.provinceService.delete(id);
            response.sendRedirect("/listProvince");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
