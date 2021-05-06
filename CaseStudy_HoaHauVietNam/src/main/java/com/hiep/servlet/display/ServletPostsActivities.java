package com.hiep.servlet.display;

import com.hiep.model.Posts;
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

@WebServlet(name = "ServletPostsActivities", urlPatterns = "/activities")
public class ServletPostsActivities extends HttpServlet {
    PostsService postsService = new PostsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {

            List<Posts> listPostsTop3 = this.postsService.top3();
            request.setAttribute("listPostsTop3", listPostsTop3);

            List<Posts> listPostMiss = this.postsService.listPostMiss();
            request.setAttribute("listPostMiss", listPostMiss);

            List<Posts> listActivities = this.postsService.listActivities();
            request.setAttribute("listActivities", listActivities);

            RequestDispatcher dispatcher = request.getRequestDispatcher("display/activities.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
