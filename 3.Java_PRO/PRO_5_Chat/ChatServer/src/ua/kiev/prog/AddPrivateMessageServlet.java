package ua.kiev.prog;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class AddPrivateMessageServlet extends HttpServlet {

    private MessageList msgList = MessageList.getInstance();
    private UsersMap usersMap = UsersMap.getInstance();

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {

        OutputStream os = resp.getOutputStream();
        User user = usersMap.getUser(req.getParameter("to"));
        if (user == null)
            resp.setStatus(400);

        InputStream is = req.getInputStream();
        byte[] buf = new byte[req.getContentLength()];
        is.read(buf);

        if (buf == null)
            resp.setStatus(400);

        Message msg = Message.fromJSON(new String(buf));
        if (msg != null)
            user.addPrivateMessage(msg);
        else
            resp.setStatus(400);


    }
}
