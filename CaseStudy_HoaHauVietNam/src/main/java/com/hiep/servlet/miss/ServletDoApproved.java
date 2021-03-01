package com.hiep.servlet.miss;

import com.hiep.dao.MissDao;
import com.hiep.model.Miss;
import com.hiep.service.MissService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDoApproved", urlPatterns = "/doApproved")
public class ServletDoApproved extends HttpServlet {

    MissDao missDao = new MissDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Miss miss = this.missDao.findById(id);

            if (miss.getStatus().equalsIgnoreCase("Chờ duyệt"))
                miss.setStatus("Đã duyệt");
            else if (miss.getStatus().equalsIgnoreCase("Đã duyệt"))
                miss.setStatus("Bị loại");
            else if (miss.getStatus().equalsIgnoreCase("Bị loại"))
                miss.setStatus("Chờ duyệt");
            this.missDao.update(id, miss);
            response.sendRedirect("/xetduyet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
