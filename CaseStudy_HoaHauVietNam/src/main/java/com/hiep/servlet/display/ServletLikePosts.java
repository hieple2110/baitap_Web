package com.hiep.servlet.display;

import com.hiep.dao.PostsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletLikePosts", urlPatterns = "/likePosts")
public class ServletLikePosts extends HttpServlet {
    PostsDao postsDao = new PostsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("idPosts"));
            this.postsDao.likePosts(id);
            response.sendRedirect("/viewPostsDisplay?idPosts="+id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
