package com.hiep.servlet.Login;

import com.hiep.model.Account;
import com.hiep.service.AccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ServletLogin", urlPatterns = "/login")
public class ServletLogin extends HttpServlet {
    AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String user = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        try {
            Account account = this.accountService.findUserPass(user, password);
            if (this.accountService.checkUser(user, password)) {
                if (user.equals("admin@gmail.com")) {
                    session.setAttribute("a_userName", account.getUserName());
                    session.setAttribute("account", account);
                    response.sendRedirect("/listMiss");
                } else {
                    session.setAttribute("a_userName", account.getUserName());
                    session.setAttribute("account", account);
                    response.sendRedirect("/user");
                }
            } else {
                request.setAttribute("message", "User, password please try again");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
        dispatcher.forward(request, response);
    }
}
