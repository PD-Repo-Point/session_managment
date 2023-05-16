import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.Optional;
import java.util.stream.Stream;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("This is a result page");

        //out.println(req.getAttribute("user"));

        /*String user =(String) req.getAttribute("user");  --> Request Scope
        out.println("User : "+ user);

        System.out.println("User : "+ user);*/


        // Session Tracking --- Using Cookies
        Cookie[] cookies = req.getCookies();
        out.println(this.getCookieValuesByName(cookies,"user").get());
        out.println(this.getCookieValuesByName(cookies,"programme").get());
        out.println(this.getCookieValuesByName(cookies,"person").get());


        // Request Scope
        /*String c =(String) req.getAttribute("class");
        Person p = (Person) req.getAttribute("person");

        System.out.println(c);
        out.println(c);
        out.println("<br/>");
        out.println(p);*/




    }

    private Optional<String> getCookieValuesByName(Cookie[] cookies, String name){
        return Stream.of(cookies)
                .filter(cookie -> name.equals(cookie.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
