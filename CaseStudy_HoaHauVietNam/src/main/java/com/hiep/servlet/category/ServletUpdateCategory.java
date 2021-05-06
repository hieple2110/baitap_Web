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

@WebServlet(name = "ServletUpdateCategory",urlPatterns = "/updateCategory")
public class ServletUpdateCategory extends HttpServlet {
    CategoryService categoryService = new CategoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Category category = new Category(id,name);
            request.setAttribute("message", this.categoryService.update(category.getIdCategory(), category));

            List<Category> listCategory = this.categoryService.getAll();
            request.setAttribute("listCategory",listCategory);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("idCategory"));
            Category category = this.categoryService.findById(id);
            request.setAttribute("category", category);
            RequestDispatcher dispatcher = request.getRequestDispatcher("category/updateCategory.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
