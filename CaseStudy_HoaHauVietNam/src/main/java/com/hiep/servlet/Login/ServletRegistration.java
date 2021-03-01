package com.hiep.servlet.Login;

import com.hiep.model.Account;
import com.hiep.service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletRegistration",urlPatterns = "/registration")
public class ServletRegistration extends HttpServlet {
    AccountService accountService = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            String image = request.getParameter("image");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            Account account = new Account( image,user, pass, name, email);
            request.setAttribute("message", accountService.insert(account));
           response.sendRedirect("/login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("login/registration.jsp");
        dispatcher.forward(request, response);
    }
}
