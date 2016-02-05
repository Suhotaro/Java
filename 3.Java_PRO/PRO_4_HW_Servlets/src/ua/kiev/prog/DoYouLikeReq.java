package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DoYouLikeReq extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html"); // Content-Type: text/html

        PrintWriter pw = resp.getWriter();
        pw.println("<html>"                                                     +
                   "<head> <title> HELLO </title> </head>"                      +
                   "<body>"                                                     +
                   "<form action=\"/doyoulikeans\" method=\"POST\">"            +
                   "<h1> Do you like Java?<h1>"                                 +
                   "<input type=\"radio\" name=\"button1\" value=\"YES\"> YES"  +
                   "<input type=\"radio\" name=\"button2\" value=\"NO\"> NO "   +
                   "<h1> Do you like .NET?<h1>"                                 +
                   "<input type=\"radio\" name=\"button3\" value=\"YES\"> YES " +
                   "<input type=\"radio\" name=\"button4\" value=\"NO\"> NO "   +
                   "<br>"                                                       +
                   "<input type=\"submit\"></input>"                            +
                   "</form>"                                                    +
                   "</body>"                                                    +
                   "</html>");
    }
}