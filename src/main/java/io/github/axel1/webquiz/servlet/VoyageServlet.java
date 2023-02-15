package io.github.axel1.webquiz.servlet;

import io.github.axel1.webquiz.appreciationNumerique.AppreciationInt;
import io.github.axel1.webquiz.model.entity.IAppreciation;
import io.github.axel1.webquiz.model.entity.Internaute;
import io.github.axel1.webquiz.model.entity.Voyage;
import io.github.axel1.webquiz.model.service.VoyageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "VoyageServlet", value = "/VoyageServlet")
public class VoyageServlet extends HttpServlet {
    private final VoyageService voyageService = VoyageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ville = request.getParameter("ville");
        if (ville != null) {
            List<Voyage> voyages = voyageService.getVoyagesByVille(ville);
            request.setAttribute("voyages", voyages);
        }
        request.getRequestDispatcher("voyage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Internaute internaute = (Internaute) session.getAttribute("internaute");
        if (internaute != null) {
            String ville = request.getParameter("ville");
            String dateDepart = request.getParameter("dateDepart");
            String appreciation = request.getParameter("appreciation");

            if (ville != null && dateDepart != null && appreciation != null) {
                IAppreciation appreciationObject = new AppreciationInt(appreciation);
                try {
                    voyageService.addVoyage(internaute, ville, dateDepart, appreciationObject);
                } catch (IllegalArgumentException e) {
                    request.setAttribute("error", e.getMessage());
                    request.getRequestDispatcher("erreur.jsp").forward(request, response);
                }
                response.sendRedirect("VoyageServlet");
            }
        } else {
            response.sendRedirect("formInternaute.html");
        }
    }
}
