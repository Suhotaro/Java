package ua.kiev.prog.Room;

import java.util.HashMap;

public class RoomMap {
    private static final RoomMap roomMap = new RoomMap();
    private final HashMap<String, Room> room_users = new HashMap<String, Room >();

    public static RoomMap getInstance() {
        return roomMap;
    }

    private RoomMap() {}

    public void addRoom(String name, Room room) {
        room_users.put(name, room);
    }
    public Room getRoom(String name) { return room_users.get(name); }

    public void deleteRoom(String room_name) {
        room_users.remove(room_name);
    }
}
