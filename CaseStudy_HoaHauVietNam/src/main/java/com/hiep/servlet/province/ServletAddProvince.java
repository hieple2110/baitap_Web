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
import java.util.List;

@WebServlet(name = "ServletAddProvince", urlPatterns = "/addProvince")
public class ServletAddProvince extends HttpServlet {
    ProvinceService provinceService = new ProvinceService();
    ProvinceDao provinceDao = new ProvinceDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            String name = request.getParameter("name");
            Province province = new Province(name);
//            this.provinceDao.insert(province);
//            List<Province> listProvince = this.provinceDao.getAll();
            request.setAttribute("message", this.provinceService.insert(province));
            List<Province> listProvince = this.provinceService.getAll();

            request.setAttribute("listProvince",listProvince);
            RequestDispatcher dispatcher = request.getRequestDispatcher("province/listProvince.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
