package com.hiep.servlet.miss;

import com.hiep.dao.EducationDao;
import com.hiep.dao.MissDao;
import com.hiep.dao.NationDao;
import com.hiep.dao.ProvinceDao;
import com.hiep.model.*;
import com.hiep.service.EducationService;
import com.hiep.service.MissService;
import com.hiep.service.NationService;
import com.hiep.service.ProvinceService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletListMiss", urlPatterns = "/listMiss")
public class ServletListMiss extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();
    NationService nationService = new NationService();
    EducationService educationService = new EducationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Miss> listMiss = this.missService.getAll();
            request.setAttribute("listMiss",listMiss);
            List<Province> listProvince = this.provinceService.getAll();
            request.setAttribute("listProvince",listProvince);
            List<Nation> listNation = this.nationService.getAll();
            request.setAttribute("listNation",listNation);
            List<Education> listEducation = this.educationService.getAll();
            request.setAttribute("listEducation",listEducation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("miss/listMiss.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
