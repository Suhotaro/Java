package ua.kiev.prog.Room;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.Msg.Message;

import java.util.ArrayList;
import java.util.List;

public class Room {
    String name;
    private final List<String> room_users = new ArrayList<String>();
    private final List<Message> massages = new ArrayList<Message>();

    public Room(String name)
    {
        this.name = name;
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }

    public void addUser(String user) { room_users.add(user); }
    public boolean removeUser(String user)
    {
        room_users.remove(user);
        if (room_users.isEmpty())
            return true;
        return false;
    }

    public void addMsgToRoom(Message msg) { massages.add(msg); }
    public String toJSON(int n)
    {
        List<Message> res = new ArrayList<Message>();
        for (int i = n; i < massages.size(); i++)
            res.add(massages.get(i));

        if (res.size() > 0) {
            Gson gson = new GsonBuilder().create();
            return gson.toJson(res.toArray());
        }
        else
            return null;
    }
}
