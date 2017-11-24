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

@WebServlet("/user-list")
public class UsersListServlet extends HttpServlet{
    @EJB
    UsersRepositoryDao users;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        for(User user : users.getUsersList()) {
            writer.println("<!DOCTYPE html><html><p>"+user.getName() + " " + user.getSurname()+"</p></body></html");
        }
    }
}
