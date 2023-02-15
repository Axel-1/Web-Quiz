package io.github.axel1.webquiz.servlet;

import io.github.axel1.webquiz.model.entity.Internaute;
import io.github.axel1.webquiz.model.service.InternauteService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "InternauteServlet", value = "/InternauteServlet")
public class InternauteServlet extends HttpServlet {

    private final InternauteService internauteService = InternauteService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Internaute internaute = (Internaute) session.getAttribute("internaute");
        if (internaute != null) {
            request.setAttribute("internaute", internaute);
            request.getRequestDispatcher("internaute.jsp").forward(request, response);
        } else {
            response.sendRedirect("formInternaute.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        HttpSession session = request.getSession();
        if (nom != null) {
            session.setAttribute("internaute", internauteService.getOrAddInternaute(nom));
        }
        response.sendRedirect("InternauteServlet");
    }
}
