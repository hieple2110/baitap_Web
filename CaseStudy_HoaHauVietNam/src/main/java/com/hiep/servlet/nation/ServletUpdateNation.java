package com.hiep.servlet.nation;

import com.hiep.dao.NationDao;
import com.hiep.model.Education;
import com.hiep.model.Nation;
import com.hiep.service.NationService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletUpdateNation", urlPatterns = "/updateNation")
public class ServletUpdateNation extends HttpServlet {
    NationService nationService = new NationService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Nation nation = new Nation(id,name);
            request.setAttribute("message", this.nationService.update(nation.getIdNation(), nation));

            List<Nation> listNation = this.nationService.getAll();
            request.setAttribute("listNation",listNation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("nation/listNation.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            int id = Integer.parseInt(request.getParameter("idNation"));
            Nation nation = this.nationService.findById(id);
            request.setAttribute("nation", nation);
            RequestDispatcher dispatcher = request.getRequestDispatcher("nation/updateNation.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
