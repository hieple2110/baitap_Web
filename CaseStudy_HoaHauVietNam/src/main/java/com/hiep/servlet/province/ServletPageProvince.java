package com.hiep.servlet.province;

import com.hiep.model.Education;
import com.hiep.model.Miss;
import com.hiep.model.Nation;
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

@WebServlet(name = "ServletPageProvince",urlPatterns = "/pageProvince")
public class ServletPageProvince extends HttpServlet {
    ProvinceService provinceService = new ProvinceService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            listPage(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String index = request.getParameter("index");
        if (index == null) {
            index = "1";
        }
        int indexPage = Integer.parseInt(index);

        List<Province> listProvince = this.provinceService.listPage(indexPage);
        request.setAttribute("listProvince", listProvince);
        RequestDispatcher dispatcher = request.getRequestDispatcher("province/listPage.jsp");
        dispatcher.forward(request, response);
    }
}
