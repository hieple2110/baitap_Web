package com.hiep.servlet.education;

import com.hiep.dao.EducationDao;
import com.hiep.model.Education;
import com.hiep.model.Province;
import com.hiep.service.EducationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletListEducation", urlPatterns = "/listEducation")
public class ServletListEducation extends HttpServlet {
    EducationService educationService = new EducationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Education> listEducation = this.educationService.getAll();
            request.setAttribute("listEducation",listEducation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("education/listEducation.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
