package com.hiep.servlet.Login;

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

@WebServlet(name = "ServletPageHome", urlPatterns = "/hoahauvietnam.com.vn")
public class ServletPageHome extends HttpServlet {
    PostsService postsService = new PostsService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            RequestDispatcher dispatcher = request.getRequestDispatcher("login/home.jsp");
            dispatcher.forward(request, response);

    }
}
