package ua.kiev.prog.Servlets.RoomServlets;

import ua.kiev.prog.Room.Room;
import ua.kiev.prog.Room.RoomMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

public class CreatRoomServlet extends HttpServlet {

    RoomMap roomMap = RoomMap.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OutputStream os = resp.getOutputStream();

        HttpSession http_session = req.getSession(false);
        if (http_session == null) {
            os.write("Error".getBytes());
            return;
        }

        String room_name = req.getParameter("room");
        Room room = new Room(room_name);
        room.addUser((String) http_session.getAttribute("login"));

        roomMap.addRoom(room_name, room);
        os.write("OK".getBytes());
    }
}
