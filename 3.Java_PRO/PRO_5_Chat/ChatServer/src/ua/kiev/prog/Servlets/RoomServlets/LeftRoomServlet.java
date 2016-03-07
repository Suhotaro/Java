package ua.kiev.prog.Servlets.RoomServlets;

import ua.kiev.prog.Room.Room;
import ua.kiev.prog.Room.RoomMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LeftRoomServlet {

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

        boolean is_last_user = room.removeUser((String)http_session.getAttribute("login"));
        if (is_last_user)
            roomMap.deleteRoom(room_name);

        resp.setStatus(200);
    }
}
