package com.infoshareacademy.searchengine.servlets;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/find-user-by-login")
public class FindUserByLoginServlet extends HttpServlet {
    @EJB
    UsersRepositoryDao users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String login = req.getParameter("login");
        if(login == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.println("<!DOCTYPE html><html><body><h1>No login provided</h1></body></html>");
            return;
        } else {
            User user = users.getUserByLogin(login);
        }
        User user = users.getUserByLogin(login);
        if (user == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.println("<!DOCTYPE html><html><body><h1>User not found</h1></body></html>");
            return;
        } else {
            writer.println("<!DOCTYPE html><html><body>" + user.getName() + " " + user.getSurname() + "</body></html>");
        }
    }

}
