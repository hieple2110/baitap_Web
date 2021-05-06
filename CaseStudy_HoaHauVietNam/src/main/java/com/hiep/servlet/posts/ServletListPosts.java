package com.hiep.servlet.posts;

import com.hiep.dao.PostsDao;
import com.hiep.model.Category;
import com.hiep.model.Posts;
import com.hiep.model.Province;
import com.hiep.service.CategoryService;
import com.hiep.service.PostsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletListPosts", urlPatterns = "/listPosts")
public class ServletListPosts extends HttpServlet {
    PostsService postsService = new PostsService();
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Category> listCategory = this.categoryService.getAll();
            request.setAttribute("listCategory",listCategory);
            List<Posts> listPosts = this.postsService.getAll();
            request.setAttribute("listPosts",listPosts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("posts/listPosts.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
