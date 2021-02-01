package servlet;

import dao.StudentDao;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servletview", urlPatterns = "/view")
public class Servletview extends HttpServlet {
    StudentDao studentDao = new StudentDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Student student = this.studentDao.findByID(id);
            RequestDispatcher dispatcher;
            if (student == null) {
               request.setAttribute("message","Not find id Student");
               dispatcher = request.getRequestDispatcher("/listStudent");
               dispatcher.forward(request,response);
            }else {
                request.setAttribute("student", student);
                dispatcher = request.getRequestDispatcher("view.jsp");
                dispatcher.forward(request, response);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }
}
