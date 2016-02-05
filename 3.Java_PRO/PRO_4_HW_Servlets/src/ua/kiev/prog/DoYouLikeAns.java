package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DoYouLikeAns extends HttpServlet {

    static final String TEMPLATE = "<html>" +
            "<head><title>Prog.kiev.ua</title></head>" +
            "<body><h1>%s<br>%s</h1></body></html>";

    int yes1 = 0;
    int yes2 = 0;

    int no1 = 0;
    int no2 = 0;

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html"); // Content-Type: text/html

        String button1 = req.getParameter("button1");
        String button2 = req.getParameter("button2");
        String button3 = req.getParameter("button3");
        String button4 = req.getParameter("button4");

        if (button1 == null)
            button1 = "none";

        if (button2 == null)
            button2 = "none";

        if (button3 == null)
            button3 = "none";

        if (button4 == null)
            button4 = "none";

        if (button1.equals("YES"))
            yes1 += 1;
        else
            no1 += 1;

        if (button3.equals("YES"))
            yes2 += 1;
        else
            no2 += 1;

        String ans1 = "Question 1: yes = "+ yes1 + ", no = " + no1 + " ";
        String ans2 = "Question 2: yes = "+ yes2 + ", no = " + no2 + " ";

        resp.getWriter().println(String.format(TEMPLATE, ans1, ans2));
    }
}
