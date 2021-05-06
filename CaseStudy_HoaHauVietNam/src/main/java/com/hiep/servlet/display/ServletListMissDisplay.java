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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletListMissDisplay", urlPatterns = "/listMissDisplay")
public class ServletListMissDisplay extends HttpServlet {
    MissService missService = new MissService();
    PostsService postsService = new PostsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Miss> listMiss = missService.getAll();
            request.setAttribute("listMiss", listMiss);
            List<Posts> listPostsTop3 = postsService.top3();
            request.setAttribute("listPostsTop3", listPostsTop3);
            List<Posts> listActivities = postsService.listActivities();
            request.setAttribute("listActivities", listActivities);

            RequestDispatcher dispatcher = request.getRequestDispatcher("display/listMissDisplay.jsp");
            dispatcher.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
