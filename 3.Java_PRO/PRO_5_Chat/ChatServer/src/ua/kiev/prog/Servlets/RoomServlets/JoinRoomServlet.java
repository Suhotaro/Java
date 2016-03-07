package ua.kiev.prog.Servlets.RoomServlets;

import ua.kiev.prog.Room.Room;
import ua.kiev.prog.Room.RoomMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JoinRoomServlet  extends HttpServlet{
    RoomMap roomMap = RoomMap.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession http_session = req.getSession(false);
        if (http_session == null) {
            resp.setStatus(400);
            return;
        }

        String room_name = req.getParameter("room");
        Room room = roomMap.getRoom(room_name);
        if (room == null) {
            resp.setStatus(400);
            return;
        }

        room.addUser((String)http_session.getAttribute("login"));
        resp.setStatus(200);
    }
}
