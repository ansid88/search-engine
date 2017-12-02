package com.infoshareacademy.searchengine.servlets;
import com.infoshareacademy.searchengine.cdibeans.MaxPulse;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.User;

import javax.ejb.EJB;
import javax.inject.Inject;
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

    @Inject
    MaxPulse pulse;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        if(id == null) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            writer.println("<!DOCTYPE html><html><body><h1>No ID provided</h1></body></html>");
            return;
        } else {
            User user = users.getUserById(Integer.parseInt(id));
        }
        User user = users.getUserById(Integer.parseInt(id));
        if (user == null){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.println("<!DOCTYPE html><html><h1><body>User not found</h1></body></html>");
            return;
        } else {
            writer.println("<!DOCTYPE html><html><body>" + user.getName() + " " + user.getSurname() +
                    " " + pulse.calculatePulse(user.getAge(), user.getGender()) + "</body></html>");
        }
    }
}
