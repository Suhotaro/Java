package ua.kiev.prog.Servlets.PrivateMsgServlets;

import ua.kiev.prog.Msg.Message;
import ua.kiev.prog.Msg.MessageList;
import ua.kiev.prog.User.User;
import ua.kiev.prog.User.UsersMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AddPrivateMessageServlet extends HttpServlet {

    private UsersMap usersMap = UsersMap.getInstance();

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        HttpSession http_session = req.getSession(false);
        if (http_session == null)
            resp.setStatus(400);


        InputStream is = req.getInputStream();
        byte[] buf = new byte[req.getContentLength()];
        is.read(buf);

        if (buf == null)
            resp.setStatus(400);


        Message msg = Message.fromJSON(new String(buf));
        User user = usersMap.getUser(msg.getTo());
        if (user == null)
            resp.setStatus(400);

        if (msg != null)
            user.addPrivateMessage(msg);
    }
}
