package ua.kiev.prog.User;

import java.util.*;

/*
    Singleton pattern is used here
 */
public class UsersMap {

    /*------------------ Singleton --------------------*/
    private static final UsersMap usersMap = new UsersMap();
    private final HashMap<String, User> registered_users = new HashMap<String, User>();

    public static UsersMap getInstance() {
        return usersMap;
    }

    private UsersMap() {
    }

    public int addUser(String login, User user) {
        User tmp = registered_users.get(login);
        if (tmp != null)
            return 0;

        registered_users.put(login, user);
        return 1;
    }

    public User getUser(String login)
    {
        User user = registered_users.get(login);
        user.updateTimestamp();

        return user;
    }

    public List<String> getOnlineUsers()
    {
        List<String> online_users = new LinkedList<String>();

        Set<String> names = registered_users.keySet();
        for (String name : names)
        {
            User user = registered_users.get(name);
            if (user.isOnline())
                online_users.add(user.getName());
        }

        if (!online_users.isEmpty())
            return online_users;
        return null;

    }

    public int authorizeUser(String login, String password) {
        User tmp = registered_users.get(login);
        if (tmp == null)
            return 0;

        if (!tmp.getPassword().equals(password))
            return 0;
        return 1;
    }

    public LinkedList<String> getUserNames() {
        LinkedList<String> list = new LinkedList<String>();
        for (Map.Entry<String, User> entry : registered_users.entrySet()) {
            User user = registered_users.get(entry.getKey());
            list.add(user.getName());
        }

        return list;
    }
}