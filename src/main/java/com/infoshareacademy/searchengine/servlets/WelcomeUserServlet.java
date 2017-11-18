package com.infoshareacademy.searchengine.servlets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        PrintWriter writer = resp.getWriter();
        if (name == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        } else {
            writer.println("<!DOCTYPE html><html><body>hello: " + name + "!</body></html>");
        }



    }

}
