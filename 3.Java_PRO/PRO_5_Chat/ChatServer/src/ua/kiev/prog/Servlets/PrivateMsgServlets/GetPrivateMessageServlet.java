package ua.kiev.prog.Servlets.PrivateMsgServlets;

import ua.kiev.prog.Msg.MessageList;
import ua.kiev.prog.User.User;
import ua.kiev.prog.User.UsersMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class GetPrivateMessageServlet extends HttpServlet {

        private MessageList msgList = MessageList.getInstance();
        private UsersMap usersMap = UsersMap.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        OutputStream os = resp.getOutputStream();

        HttpSession http_session = req.getSession(false);
        if (http_session == null)
            os.write("Error".getBytes());

        String fromStr = req.getParameter("from");
        int from = Integer.parseInt(fromStr);

        String user_name = (String) http_session.getAttribute("login");
        User user = usersMap.getUser(user_name);

        String private_messages = user.toJSON(from);
        if (private_messages != null)
            os.write(private_messages.getBytes());
    }
}
