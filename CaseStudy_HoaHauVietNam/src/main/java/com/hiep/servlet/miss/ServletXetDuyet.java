package com.hiep.servlet.miss;

import com.hiep.dao.EducationDao;
import com.hiep.dao.MissDao;
import com.hiep.dao.NationDao;
import com.hiep.dao.ProvinceDao;
import com.hiep.model.Education;
import com.hiep.model.Miss;
import com.hiep.model.Nation;
import com.hiep.model.Province;
import com.hiep.service.MissService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletXetDuyet", urlPatterns = "/xetduyet")
public class ServletXetDuyet extends HttpServlet {
    MissService missService = new MissService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Miss> listMiss = this.missService.getAll();
            request.setAttribute("listMiss", listMiss);
            RequestDispatcher dispatcher = request.getRequestDispatcher("miss/xetduyet.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
