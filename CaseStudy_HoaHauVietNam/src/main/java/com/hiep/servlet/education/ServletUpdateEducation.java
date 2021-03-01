package com.hiep.servlet.education;

import com.hiep.dao.EducationDao;
import com.hiep.model.Education;
import com.hiep.service.EducationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUpdateEducation", urlPatterns = "/updateEducation")
public class ServletUpdateEducation extends HttpServlet {
    EducationService educationService = new EducationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Education education = new Education(id, name);
            request.setAttribute("message", this.educationService.update(education.getIdEducational(), education));
            List<Education> listEducation = this.educationService.getAll();
            request.setAttribute("listEducation",listEducation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("education/listEducation.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("idEducational"));
            Education education = this.educationService.findById(id);
            request.setAttribute("education", education);
            RequestDispatcher dispatcher = request.getRequestDispatcher("education/updateEducation.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
