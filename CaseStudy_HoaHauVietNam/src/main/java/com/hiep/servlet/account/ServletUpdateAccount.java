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

@WebServlet(name = "ServletUpdateAccount", urlPatterns = "/updateAccount")
public class ServletUpdateAccount extends HttpServlet {
    AccountService accountService = new AccountService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String image = request.getParameter("image");
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            Account account = new Account(id,image,user,pass,name,email);
            request.setAttribute("message", accountService.update(account.getIdAccount(), account));
            List<Account> listAccount = this.accountService.getAll();
            request.setAttribute("listAccount",listAccount);
            RequestDispatcher dispatcher = request.getRequestDispatcher("account/listAccount.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("idAccount"));
            Account account = this.accountService.findById(id);
            request.setAttribute("account", account);
            RequestDispatcher dispatcher = request.getRequestDispatcher("account/updateAccount.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
