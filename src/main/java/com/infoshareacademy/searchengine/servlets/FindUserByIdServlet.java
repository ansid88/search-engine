package com.infoshareacademy.searchengine.servlets;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDaoBean;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-id")
public class FindUserByIdServlet extends HttpServlet {

    @EJB
    UsersRepositoryDao users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //UsersRepositoryDao users = new UsersRepositoryDaoBean();
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        if(id == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.println("<!DOCTYPE html><html><body>No ID provided</body></html>");
            return;
        } else {
            User user = users.getUserById(Integer.parseInt(id));
        }
        User user = users.getUserById(Integer.parseInt(id));
        if (user == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.println("<!DOCTYPE html><html><body>User not found</body></html>");
            return;
        } else {
            writer.println("<!DOCTYPE html><html><body>" + user.getName() + " " + user.getSurname() + "</body></html>");
        }
    }
}
