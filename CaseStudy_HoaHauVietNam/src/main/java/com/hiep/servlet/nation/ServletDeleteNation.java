package com.hiep.servlet.nation;

import com.hiep.dao.MissDao;
import com.hiep.dao.NationDao;
import com.hiep.model.Nation;
import com.hiep.service.MissService;
import com.hiep.service.NationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ServletDeleteNation", urlPatterns = "/deleteNations")
public class ServletDeleteNation extends HttpServlet {
    MissService missService = new MissService();
    NationService nationService = new NationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            this.missService.delete_miss_nation(id);
            this.nationService.delete(id);
            response.sendRedirect("/listNation");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
