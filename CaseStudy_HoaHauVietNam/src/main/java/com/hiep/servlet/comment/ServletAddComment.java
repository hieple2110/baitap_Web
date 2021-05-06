package com.hiep.servlet.comment;

import com.hiep.dao.CommentDao;
import com.hiep.model.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletAddComment", urlPatterns = "/addComment")
public class ServletAddComment extends HttpServlet {
    CommentDao commentDao = new CommentDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        try {
            String content = request.getParameter("content");
            int posts = Integer.parseInt(request.getParameter("posts"));
            int account = Integer.parseInt(request.getParameter("account"));
            String image = request.getParameter("image");
            String name = request.getParameter("name");
            Comment comment = new Comment(content,posts,account,image,name);
            this.commentDao.insert(comment);
            response.sendRedirect("/viewPostsDisplay?idPosts="+posts);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
