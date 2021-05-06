package com.hiep.servlet.display;

import com.hiep.dao.CommentDao;
import com.hiep.dao.PostsDao;
import com.hiep.model.Account;
import com.hiep.model.Comment;
import com.hiep.model.Posts;
import com.hiep.service.AccountService;
import com.hiep.service.PostsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletViewPostsDisplay", urlPatterns = "/viewPostsDisplay")
public class ServletViewPostsDisplay extends HttpServlet {
    PostsService postsService = new PostsService();
    CommentDao commentDao = new CommentDao();
    PostsDao postsDao = new PostsDao();
    AccountService accountService = new AccountService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");


        int id = 0;
        try {

            List<Posts> listPostsTop3 = this.postsService.top3();
            request.setAttribute("listPostsTop3", listPostsTop3);
            List<Posts> listActivities = this.postsService.listActivities();
            request.setAttribute("listActivities", listActivities);

            id = Integer.parseInt(request.getParameter("idPosts"));
            this.postsDao.viewPosts(id);

            List<Comment> listComment = this.commentDao.selectCommentsInPost(id);
            request.setAttribute("listComment", listComment);

            Posts posts = this.postsService.findById(id);
            request.setAttribute("posts", posts);
            if (posts == null) {
                response.sendRedirect("/error?code=02");
                return;
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("display/viewPostsDisplay.jsp");
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            response.sendRedirect("/error?code=02");
        }
    }
}
