package tool.controller;

import tool.service.UserService;
import tool.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (userService.checkIfValid(username, password)) {
            req.getSession().setAttribute("user", username);

            resp.sendRedirect(getServletContext().getContextPath() + "/");
        } else {
            req.setAttribute("invalidData", true);
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}