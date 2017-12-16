package com.infoshareacademy.searchengine.servlets;
import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;

@WebServlet("/add-user")
public class AddUserServlet extends HttpServlet {
    @EJB
    UsersRepositoryDao users;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String login = req.getParameter("login");

        if(Stream.of(id, name, surname, age, login).anyMatch(x -> x == null)) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            writer.println("<!DOCTYPE html><html><body>Some arguments are missing</body></html>");
            return;
        } else {
            User user = new User();
            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setSurname(surname);
            user.setAge(Integer.parseInt(age));
            user.setLogin(login);

            for(User person : users.getUsersList()) {
                person.getId();
                if(user.getId() == person.getId()) {
                    resp.setStatus(HttpServletResponse.SC_CONFLICT);
                    writer.println("<!DOCTYPE html><html><body>User with given ID already exists</body></html>");
                    return;
                } else {
                    users.addUser(user);
                    writer.println("<!DOCTYPE html><html><body>user added::<br />" + user.getName());
                    writer.println(user.getSurname() + "</body></html>");
                }
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");
        String login = req.getParameter("login");
        String gender = req.getParameter("gender");

            User user = new User();
            user.setId(Integer.parseInt(id));
            user.setName(name);
            user.setSurname(surname);
            user.setAge(Integer.parseInt(age));
            user.setLogin(login);
//            if(gender.equals("Man")) {
//                user.setGender(Gender.MAN);
//            } else if(gender.equals("Woman")) {
//                user.setGender(Gender.WOMAN);
//            }


            users.addUser(user);
            writer.println("<!DOCTYPE html><html><body>user added:<br />" + user.getName());
            writer.println(user.getSurname() + "</body></html>");



    }

}
