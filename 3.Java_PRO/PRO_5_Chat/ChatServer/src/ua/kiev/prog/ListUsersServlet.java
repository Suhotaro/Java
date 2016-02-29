package ua.kiev.prog;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

public class ListUsersServlet extends HttpServlet {

    private UsersMap usersMap = UsersMap.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        OutputStream os = resp.getOutputStream();

        HttpSession http_session = req.getSession(false);
        if (http_session == null)
            os.write("Error".getBytes());

        String ID = req.getRequestedSessionId();
        String str = (String)http_session.getAttribute("login");

        /* Send test Cookie */
        Cookie cook = new Cookie("TEST", "hello_user");
        resp.addCookie(cook);

        List<String> list = usersMap.getOnlineUsers();
        if (list == null) {
            os.write("Error".getBytes());
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append("User: ");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(list.get(i));
            sb.append("&");
        }

        os.write(sb.toString().getBytes());
        sb.setLength(0);
    }
}

