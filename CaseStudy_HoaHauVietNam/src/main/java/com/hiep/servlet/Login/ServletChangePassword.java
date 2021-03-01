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
import java.sql.SQLException;

@WebServlet(name = "ServletChangePassword", urlPatterns = "/changPassword")
public class ServletChangePassword extends HttpServlet {
    AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Account accounts = (Account) session.getAttribute("account");


        if (accounts != null) {
            String user = request.getParameter("user");
            String oldPass = request.getParameter("oldPassword");
            String newPassword = request.getParameter("newPassword");

            try {
                if (this.accountService.checkUser(user, oldPass)) {
                    Account newAccount = new Account(accounts.getIdAccount(), accounts.getImage(), user, newPassword, accounts.getFullName(), accounts.getEmail(),  accounts.getStatus());
                    this.accountService.update(accounts.getIdAccount(), newAccount);
                    session.setAttribute("user", newAccount);
                    session.setAttribute("message", "Password has been changed successfully ");
                    if (accounts.getUserName().equals("admin@gmail.com")) {
                        response.sendRedirect("/listMiss");
                    } else {
                        session.setAttribute("message", "Password has been changed successfully ");
                        response.sendRedirect("/user");
                    }

                } else {
                    session.setAttribute("message", "User not exist. Please try again!");
                    response.sendRedirect("/login");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            response.sendRedirect("/login");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        RequestDispatcher dispatcher;
        if (account != null) {
            request.setAttribute("account", account);
            dispatcher = request.getRequestDispatcher("login/changePassword.jsp");
        } else {
            dispatcher = request.getRequestDispatcher("login/login.jsp");
        }
        dispatcher.forward(request, response);
    }
}
