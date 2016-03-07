package ua.kiev.prog.User;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.kiev.prog.Msg.Message;

import java.util.ArrayList;
import java.util.List;

public class User
{
    String name;
    String password;
    String ID;

    long timestamp;

    private final List<Message> private_massages = new ArrayList<Message>();

    public User(String name, String password, String ID)
    {
        this.name = name;
        this.password = password;
        this.ID = ID;

        timestamp = System.currentTimeMillis() + 3600;
    }

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
        this.ID = null;

        timestamp = System.currentTimeMillis() + 3600;
    }

    public void setName (String name) {this.name = name;}
    public void setPassword (String password) {this.password = password;}
    public void setID (String ID) {this.ID = ID;}

    public String getName() { return this.name;}
    public String getPassword() { return this.password;}
    public String getID() { return this.ID;}

    public void updateTimestamp()
    {
        timestamp = System.currentTimeMillis() + 3600;
    }

    public boolean isOnline()
    {
        if (System.currentTimeMillis() == timestamp)
            return false;
        return true;
    }

    public void addPrivateMessage (Message msg) {private_massages.add(msg);}
    public String toJSON(int n)
    {
        List<Message> res = new ArrayList<Message>();
        for (int i = n; i < private_massages.size(); i++)
            res.add(private_massages.get(i));

        if (res.size() > 0) {
            Gson gson = new GsonBuilder().create();
            return gson.toJson(res.toArray());
        }
        else
            return null;

    }


}