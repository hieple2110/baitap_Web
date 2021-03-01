package com.hiep.servlet.Login;

import com.hiep.model.Education;
import com.hiep.model.Miss;
import com.hiep.model.Nation;
import com.hiep.model.Province;
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
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletRegistrationContest", urlPatterns = "/registrationContest")
public class ServletRegistrationContest extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();
    NationService nationService = new NationService();
    EducationService educationService = new EducationService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            String name = request.getParameter("name");
            Date dateOfBirth = Date.valueOf(request.getParameter("date"));
            String passport = request.getParameter("pass");
            String address = request.getParameter("address");
            String job = request.getParameter("job");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            int province = Integer.parseInt(request.getParameter("province"));
            int nation = Integer.parseInt(request.getParameter("nation"));
            int education = Integer.parseInt(request.getParameter("education"));
            String image = request.getParameter("image");
            Miss miss = new Miss(name, dateOfBirth, passport, address, job, email, phone, province, nation, education, image);
            request.setAttribute("message", this.missService.insert(miss));

            RequestDispatcher dispatcher = request.getRequestDispatcher("login/home.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            List<Miss> listMiss = this.missService.getAll();
            request.setAttribute("listMiss", listMiss);
            List<Province> listProvince = this.provinceService.getAll();
            request.setAttribute("listProvince", listProvince);
            List<Nation> listNation = this.nationService.getAll();
            request.setAttribute("listNation", listNation);
            List<Education> listEducation = this.educationService.getAll();
            request.setAttribute("listEducation", listEducation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("login/registrationContest.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
