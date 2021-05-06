package com.hiep.servlet.display;

import com.hiep.model.Miss;
import com.hiep.model.Posts;
import com.hiep.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletViewMissDisplay", urlPatterns = "/viewMissDisplay")
public class ServletViewMissDisplay extends HttpServlet {
    MissService missService = new MissService();
    PostsService postsService = new PostsService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Posts> listPostsTop3 = this.postsService.top3();
            request.setAttribute("listPostsTop3", listPostsTop3);
            List<Posts> listActivities = this.postsService.listActivities();
            request.setAttribute("listActivities", listActivities);

            int id = Integer.parseInt(request.getParameter("idMiss"));
            Miss miss = this.missService.findById(id);
            request.setAttribute("miss", miss);
            RequestDispatcher dispatcher = request.getRequestDispatcher("display/viewMissDisplay.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
