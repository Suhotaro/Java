package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class LoginServlet  extends HttpServlet {

    private UsersMap usersMap = UsersMap.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        OutputStream os = resp.getOutputStream();

        int ret = usersMap.authorizeUser(login, password);
        if (0 == ret) {
            os.write("FALSE".getBytes());
            return;
        }

        HttpSession http_session = req.getSession(true);
        String ID = http_session.getId();
        User user = usersMap.getUser(login);
        user.setID(http_session.getId());

        os.write("OK".getBytes());

    }
}
