package com.hiep.servlet.Login;

import com.hiep.dao.PostsDao;
import com.hiep.model.*;
import com.hiep.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletPageHome", urlPatterns = "/hoahauvietnam.com.vn")
public class ServletPageHome extends HttpServlet {
    PostsService postsService = new PostsService();
    MissService missService = new MissService();
    CategoryService categoryService = new CategoryService();
    ProvinceService provinceService = new ProvinceService();
    NationService nationService = new NationService();
    EducationService educationService = new EducationService();
    PostsDao postsDao = new PostsDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
}
