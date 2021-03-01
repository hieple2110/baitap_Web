package com.hiep.servlet.education;

import com.hiep.dao.EducationDao;
import com.hiep.dao.MissDao;
import com.hiep.service.EducationService;
import com.hiep.service.MissService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletDeleteEducation", urlPatterns = "/deleteEducation")
public class ServletDeleteEducation extends HttpServlet {
    EducationService educationService = new EducationService();
    MissService missService = new MissService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            this.missService.delete_miss_education(id);
            this.educationService.delete(id);
            response.sendRedirect("/listEducation");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
