package com.hiep.servlet.category;

import com.hiep.service.CategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteCategory", urlPatterns = "/deleteCategory")
public class ServletDeleteCategory extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            this.categoryService.delete(id);
            response.sendRedirect("/listCategory");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
