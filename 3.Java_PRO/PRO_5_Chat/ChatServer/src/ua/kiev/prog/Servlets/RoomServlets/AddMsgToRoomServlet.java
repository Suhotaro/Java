package ua.kiev.prog.Servlets.RoomServlets;

import ua.kiev.prog.Msg.Message;
import ua.kiev.prog.Room.Room;
import ua.kiev.prog.Room.RoomMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;

public class AddMsgToRoomServlet extends HttpServlet {

    RoomMap roomMap = RoomMap.getInstance();

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        HttpSession http_session = req.getSession(false);
        if (http_session == null)
            resp.setStatus(400);

        String room_name = req.getParameter("room");
        Room room = roomMap.getRoom(room_name);
        if (room == null) {
            resp.setStatus(400);
            return;
        }

        InputStream is = req.getInputStream();
        byte[] buf = new byte[req.getContentLength()];
        is.read(buf);
        if (buf == null)
            resp.setStatus(400);

        Message msg = Message.fromJSON(new String(buf));
        if (msg != null)
            room.addMsgToRoom(msg);
    }
}
