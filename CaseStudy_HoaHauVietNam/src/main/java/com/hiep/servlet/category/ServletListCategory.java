package com.hiep.servlet.category;

import com.hiep.model.Category;
import com.hiep.model.Nation;
import com.hiep.service.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletListCategory", urlPatterns = "/listCategory")
public class ServletListCategory extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            List<Category> listCategory = this.categoryService.getAll();
            request.setAttribute("listCategory",listCategory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
