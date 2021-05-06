package com.hiep.servlet.display;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletError", urlPatterns = "/error")
public class ServletError extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        switch (code){
            case "01":
                response.sendRedirect("display/error404.jsp");
                break;
            case "02":
                response.sendRedirect("display/error404.jsp");;
                break;
            default:
                response.sendRedirect("display/error505.jsp");
        }
    }
}
