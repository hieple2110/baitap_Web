package com.hiep.servlet.account;

import com.hiep.dao.AccountDao;
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

@WebServlet(name = "ServletDeleteAccount", urlPatterns = "/deleteAccount")
public class ServletDeleteAccount extends HttpServlet {
    AccountService accountService = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            this.accountService.delete(id);
            List<Account> listAccount = this.accountService.getAll();
            request.setAttribute("listAccount",listAccount);
            RequestDispatcher dispatcher = request.getRequestDispatcher("account/listAccount.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
