package com.hiep.servlet.Login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletUser", urlPatterns = "/user")
public class ServletUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("a_userName");

        if(user == null || user.isEmpty()){
            response.sendRedirect("/login");
        }else {
            if (user.equals("admin@gmail.com")){
                response.sendRedirect("/listMiss");
            }else {
                response.sendRedirect("/pageUser");
            }
        }
    }
}
