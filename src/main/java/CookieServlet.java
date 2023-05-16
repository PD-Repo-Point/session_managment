import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Person;

import java.io.IOException;
import java.io.PrintWriter;

/*

Session  --------------- cookies ------ (session scope)
/cookie (req)  /result (req) /xyz (req)

*/

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie user1 = new Cookie("user","Alex"); // creating a cookie
        //user1.setMaxAge(60); // 10 Minutes
        // Cookies are stored in the browser side
        resp.addCookie(user1);

        Cookie student = new Cookie("programme","DevOps"); // creating a cookie
        resp.addCookie(student);

        // value is a String not an Object Type
        Person p = new Person("Alex1", "Metas1");
        Cookie person = new Cookie("person","p");
        resp.addCookie(person);

        // <a href= "result"> Go to Result Servlet  </a>
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<a href= \"result\"> Go to Result Servlet  </a>");
        out.println("</body></html>");
    }
}
