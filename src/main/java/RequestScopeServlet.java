import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Person;

import java.io.IOException;

@WebServlet("/request")
public class RequestScopeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("class", "Servlet & JSP"); // written in request scope
        req.setAttribute("person", new Person("Alex", "Metas"));

        //resp.sendRedirect("result"); // relative path - https://localhost/state-management-demo/result
        // new get request
        //resp.sendRedirect("/result"); // absolute path - https://localhost/result - 404

        req.getRequestDispatcher("/result").forward(req,resp);

    }
}
