package com.infoshareacademy.searchengine.servlets;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import com.sun.org.apache.regexp.internal.RE;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-user-steps")
public class AddUserStepsServlet extends HttpServlet {
    @EJB
    UsersRepositoryDao users;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("step").equals("1")) {
            req.getSession().setAttribute("id", req.getParameter("id"));
            req.getSession().setAttribute("login", req.getParameter("login"));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add-user-step-2.jsp");
            requestDispatcher.forward(req, resp);

        } else if (req.getParameter("step").equals("2")) {
            req.getSession().setAttribute("name", req.getParameter("name"));
            req.getSession().setAttribute("surname", req.getParameter("surname"));
            req.getSession().setAttribute("age", req.getParameter("age"));

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/add-user-step-3.jsp");
            requestDispatcher.forward(req, resp);

        } else if (req.getParameter("step").equals("3")) {
            req.getSession().setAttribute("gender", req.getParameter("gender"));

            User user = new User();
            user.setId(Integer.parseInt((String) req.getSession().getAttribute("id")));
            user.setLogin((String) req.getSession().getAttribute("login"));
            user.setName((String) req.getSession().getAttribute("name"));
            user.setSurname((String) req.getSession().getAttribute("surname"));
            user.setAge(Integer.parseInt((String) req.getSession().getAttribute("age")));

            if(req.getSession().getAttribute("gender").equals("Man")) {
                user.setGender(Gender.MAN);
            } else if(req.getSession().getAttribute("gender").equals("Woman")) {
                user.setGender(Gender.WOMAN);
            }

            users.addUser(user);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/user-list.jsp");
            requestDispatcher.forward(req, resp);
        }


    }
}
