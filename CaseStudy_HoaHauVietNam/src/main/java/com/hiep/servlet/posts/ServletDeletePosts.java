package com.hiep.servlet.posts;

import com.hiep.dao.PostsDao;
import com.hiep.service.MissService;
import com.hiep.service.PostsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeletePosts", urlPatterns = "/deletePosts")
public class ServletDeletePosts extends HttpServlet {

    PostsService postsService = new PostsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            this.postsService.delete(id);
            response.sendRedirect("/listPosts");
        } catch (NumberFormatException | SQLException e) {
            e.printStackTrace();
        }
    }
}
