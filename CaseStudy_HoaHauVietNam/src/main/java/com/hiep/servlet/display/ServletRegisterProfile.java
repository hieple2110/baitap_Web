package com.hiep.servlet.display;

import com.hiep.model.*;
import com.hiep.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "ServletRegisterProfile",urlPatterns = "/registerProfile")
public class ServletRegisterProfile extends HttpServlet {
    MissService missService = new MissService();
    ProvinceService provinceService = new ProvinceService();
    NationService nationService = new NationService();
    EducationService educationService = new EducationService();
    PostsService postsService = new PostsService();
    CategoryService categoryService = new CategoryService();
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


            List<Miss> listMiss = this.missService.getAll();
            request.setAttribute("listMiss", listMiss);

            List<Province> listProvince = this.provinceService.getAll();
            request.setAttribute("listProvince", listProvince);

            List<Nation> listNation = this.nationService.getAll();
            request.setAttribute("listNation", listNation);

            List<Education> listEducation = this.educationService.getAll();
            request.setAttribute("listEducation", listEducation);

            List<Posts> listPosts = this.postsService.getAll();
            request.setAttribute("listPosts", listPosts);

            List<Posts> listPostsTop3 = this.postsService.top3();
            request.setAttribute("listPostsTop3", listPostsTop3);

            List<Posts> listPostsTop8 = this.postsService.top8();
            request.setAttribute("listPostsTop8", listPostsTop8);

            List<Posts> listPostsTop10 = this.postsService.top10();
            request.setAttribute("listPostsTop10", listPostsTop10);

            List<Posts> listDonors = this.postsService.listDonors();
            request.setAttribute("listDonors", listDonors);

            List<Posts> listActivities = this.postsService.listActivities();
            request.setAttribute("listActivities", listActivities);



            List<Category> listCategory = this.categoryService.getAll();
            request.setAttribute("listCategory", listCategory);

            RequestDispatcher dispatcher = request.getRequestDispatcher("login/home.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {

            List<Province> listProvince = this.provinceService.getAll();
            request.setAttribute("listProvince", listProvince);
            List<Nation> listNation = this.nationService.getAll();
            request.setAttribute("listNation", listNation);
            List<Education> listEducation = this.educationService.getAll();
            request.setAttribute("listEducation", listEducation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("display/registerProfile.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
