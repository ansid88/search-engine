package com.infoshareacademy.searchengine.servlets;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/welcome-user")
public class WelcomeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("name", req.getParameter("name"));
        req.getSession().setAttribute("session", req.getParameter("name"));
        req.setAttribute("salary", req.getAttribute("salary"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/welcome-user.jsp");
        requestDispatcher.forward(req, resp);
    }

}
