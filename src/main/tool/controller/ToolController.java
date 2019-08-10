package tool.controller;

import tool.service.ToolService;
import tool.service.ToolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class ToolController extends HttpServlet {

    private final ToolService toolService = new ToolServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tools", toolService.getAllTools());

        getServletContext().getRequestDispatcher("/tools.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        long id = Long.parseLong(req.getParameter("id"));

        // linijka ponizej pwoduje ze po kazdym kliknieciu przycisku odswierza sie strona z pliku tools.jsp
        req.setAttribute("tools", toolService.getAllTools());

        switch (action) {
            case "take": {
                toolService.setAvailability(false, id);
                break;
            }
            case "return": {
                toolService.setAvailability(true, id);
                break;
            }
        }
        //przeglądarka wysswietla to co wyrzuci link ponizej
        getServletContext().getRequestDispatcher("/tools.jsp").forward(req, resp);
        //
        resp.sendRedirect(getServletContext().getContextPath());

    }
}