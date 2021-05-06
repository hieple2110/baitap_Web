package com.hiep.servlet.posts;

import com.hiep.dao.PostsDao;
import com.hiep.model.Posts;
import com.hiep.service.PostsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletAddPosts", urlPatterns = "/addPosts")
public class ServletAddPosts extends HttpServlet {

    PostsService postsService = new PostsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try {
            String image = request.getParameter("image");
            String title = request.getParameter("title");
            String shortContent = request.getParameter("short");
            String fullContent = request.getParameter("full");
            int category = Integer.parseInt(request.getParameter("category"));
            Posts posts = new Posts(image, title, shortContent, fullContent, category);
            request.setAttribute("message", this.postsService.insert(posts));
            List<Posts> listPosts = this.postsService.getAll();
            request.setAttribute("listPosts", listPosts);
            RequestDispatcher dispatcher = request.getRequestDispatcher("posts/listPosts.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
