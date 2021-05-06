package com.hiep.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = { "/addAccount","/deleteAccount","/listAccount","/updateAccount","/viewAccount","/addCategory","/deleteCategory",
        "/listCategory","/updateCategory","/addComment","/error","/addEducation","/deleteEducation","/listEducation","/updateEducation",
        "/addMiss","/deleteMiss","/doApproved","/choDuyet","/daDuyet","/biLoai","/listMiss","/listPage","/listSearchMiss",
        "/updateMiss","/viewMiss","/xetduyet","/addNation", "/deleteNations","/listNation","/updateNation","/addPosts",
        "/deletePosts","/listPosts","/updatePosts","/viewPosts","/addProvince","/deleteProvince", "/listProvince","/pageProvince","/updateProvince"})
public class LoginFilter implements Filter {
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Object account = session.getAttribute("account");
        if (account == null) {
            res.sendRedirect(req.getContextPath() + "/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
