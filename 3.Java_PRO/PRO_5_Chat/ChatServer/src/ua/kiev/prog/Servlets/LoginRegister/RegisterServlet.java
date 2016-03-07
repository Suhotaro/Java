package ua.kiev.prog.Servlets.LoginRegister;


import ua.kiev.prog.User.User;
import ua.kiev.prog.User.UsersMap;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;

public class RegisterServlet extends HttpServlet {

    private UsersMap usersMap = UsersMap.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException
    {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        OutputStream os = resp.getOutputStream();

        User new_user = new User(login, password);

        int ret = usersMap.addUser(login, new_user);
        if (ret != 1) {
            os.write("FALSE".getBytes());
            return;
        }

        /* Create session for login user */
        HttpSession http_session = req.getSession(true);

        /* Test to set attributes */
        http_session.setAttribute("login", login);
        new_user.setID(http_session.getId());

        os.write("OK".getBytes());
    }
}
