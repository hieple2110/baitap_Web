package com.hiep.filter;

import com.hiep.model.Account;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter",urlPatterns = { "/addAccount","/deleteAccount","/listAccount","/updateAccount","/viewAccount","/addCategory","/deleteCategory",
        "/listCategory","/updateCategory","/addComment","/error","/addEducation","/deleteEducation","/listEducation","/updateEducation",
        "/addMiss","/deleteMiss","/doApproved","/choDuyet","/daDuyet","/biLoai","/listMiss","/listPage","/listSearchMiss",
        "/updateMiss","/viewMiss","/xetduyet","/addNation", "/deleteNations","/listNation","/updateNation","/addProvince","/deleteProvince", "/listProvince","/pageProvince","/updateProvince"})
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        if (account == null || !account.getDecentralization().equals("admin")) {

            response.sendRedirect(request.getContextPath() + "/hoahauvietnam.com.vn");
        } else {
            chain.doFilter(req, resp);
        }
    }



}
