package ua.kiev.prog.Servlets.RoomServlets;

import ua.kiev.prog.Room.Room;
import ua.kiev.prog.Room.RoomMap;
import ua.kiev.prog.User.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class GetRoomMsgsServlet extends HttpServlet {

    RoomMap roomMap = RoomMap.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException
    {
        OutputStream os = resp.getOutputStream();

        HttpSession http_session = req.getSession(false);
        if (http_session == null)
            os.write("Error".getBytes());

        String fromStr = req.getParameter("from");
        int from = Integer.parseInt(fromStr);

        String room_name = req.getParameter("room");
        Room room = roomMap.getRoom(room_name);
        if (room == null) {
            resp.setStatus(400);
            return;
        }

        String private_messages = room.toJSON(from);
        if (private_messages != null)
            os.write(private_messages.getBytes());
    }
}
