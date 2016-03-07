package ua.kiev.prog;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

class GetThread extends Thread {
	private int n;

    private int num_msg = 0;
    private int num_priv_msg = 0;
    private int num_room_msg = 0;

    private String cookie_name;
    private String cookie_value;

    enum MSG_TYPE {MSG, PRIV_MSG, ROOM_MSG};

    public GetThread(String cookie_name, String cookie_value)
    {
        this.cookie_name = cookie_name;
        this.cookie_value = cookie_value;
    }

    private void send (String req, MSG_TYPE type) throws Exception
    {
        URL url = null;
        if (type == MSG_TYPE.MSG)
            url = new URL(req + num_msg);
        else if (type == MSG_TYPE.PRIV_MSG)
            url = new URL(req + num_priv_msg);
        else
            url = new URL(req + num_room_msg);

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestProperty("Cookie", cookie_name + "=" + cookie_value);

        InputStream is = http.getInputStream();
        try {
            int sz = is.available();
            if (sz > 0) {
                byte[] buf = new byte[is.available()];
                is.read(buf);

                Gson gson = new GsonBuilder().create();
                Message[] list = gson.fromJson(new String(buf), Message[].class);

                for (Message m : list) {
                    System.out.println(m);

                    if (type == MSG_TYPE.MSG)
                        num_msg++;
                    else if (type == MSG_TYPE.PRIV_MSG)
                        num_priv_msg++;
                    else
                        num_room_msg++;
                }
            }
        } finally {
            is.close();
        }
    }

	@Override
	public void run() {
		try {
			while (!isInterrupted()) {
                send( "http://localhost:8080/get?from=", MSG_TYPE.MSG);
                send("http://localhost:8080/getprivmsg?from=", MSG_TYPE.PRIV_MSG);
                send("http://localhost:8080/getprivmsg?from=", MSG_TYPE.ROOM_MSG);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return;
		}
	}
}

public class Main {

    static String login;
    static String password;

    static String cookie_name;
    static String cookie_value;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
            System.out.println("Are you new user? yes/no:");
            String ans = scanner.nextLine();
            boolean ret;

            while(true)
			{
                if ("yes".equals(ans.toLowerCase()) || "y".equals(ans.toLowerCase()))
                {
                    System.out.println("Enter login: ");
                    login = scanner.nextLine();

                    System.out.println("Enter password: ");
                    password = scanner.nextLine();

                    ret = register(login, password);
                    if (ret)
                        break;

                    System.out.println("  This name already exists\n  try new one\n");
                }
                else if ("no".equals(ans.toLowerCase()) || "n".equals(ans.toLowerCase()))
                {
                    System.out.println("Enter login: ");
                    login = scanner.nextLine();

                    System.out.println("Enter password: ");
                    password = scanner.nextLine();

                    ret = login(login, password);
                    if (ret)
                        break;
                }

                System.out.println("Wrong: enter yes/no");
                ans = scanner.nextLine();
			}


            GetThread th = new GetThread(cookie_name, cookie_value);
            th.setDaemon(true);
            th.start();


            while(true)
            {
                Info();

                System.out.println("Enter command: ");
                int command = scanner.nextInt();

                switch (command)
                {
                    case 1: sendToAll() ; break;
                    case 2: listUsers(); break;
                    case 3: sendTo(); break;
                    case 4: createRoom(); break;
                    case 5: joinRoom(); break;
                    case 6: leftRoom(); break;
                    case 7: sendMsgToRoom(); break;


                    default: break;
                }
            }
		} finally {
			scanner.close();
		}
	}

    private static boolean register(String log, String pass)
    {
        String ret = send("http://localhost:8080/register?login=" + log + "&password=" + pass, false);
        if ("OK".equals(ret))
            return true;
        else
            return false;
    }

    private static boolean login(String log, String pass)
    {
        String ret = send("http://localhost:8080/login?login=" + log + "&password=" + pass, false);
        if ("OK".equals(ret))
            return true;
        else
            return false;
    }

    private static void sendToAll()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write message to ALL: ");

        String text = scanner.nextLine();
        if (text.isEmpty())
            return;

        Message m = new Message();
        m.setText(text);
        m.setFrom(login);

        try {
            int res = m.send("http://localhost:8080/add", cookie_name, cookie_value);
            if (res != 200) {
                System.out.println("HTTP error: " + res);
                return;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private static void listUsers()
    {
        String respond = send("http://localhost:8080/listusers", true);
        System.out.print( "\n----------------------\n" +
                          "Online Users:\n");

        if (respond == null)
            return;

        String []users = respond.split("&");
        if (users == null)
            return;

        for (String user : users)
            System.out.println(user);
        System.out.print("\n----------------------\n");
    }

    private static void sendTo()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a name the massage will be sent to: ");
        String to = scanner.nextLine();
        System.out.print("Type your massage: ");
        String text = scanner.nextLine();
        if (text.isEmpty())
            return;

        Message m = new Message();
        m.setText(text);
        m.setFrom(login);
        m.setTo(to);

        try {
            int res = m.send("http://localhost:8080/sendto", cookie_name, cookie_value);
            if (res != 200) {
                System.out.println("HTTP error: " + res);
                return;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private static void createRoom()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Room name: ");
        String room_name = scanner.nextLine();

        send("http://localhost:8080/creatroom?room=" + room_name, true);
    }

    private static void joinRoom(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input room you want to join: ");
        String room_name = scanner.nextLine();

        send("http://localhost:8080/joinroom?room=" + room_name, true);
    }

    private static void leftRoom(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input room you want to left: ");
        String room_name = scanner.nextLine();

        send("http://localhost:8080/leftroom?room=" + room_name, true);
    }

    private static void sendMsgToRoom(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type a Room the massage will be sent to: ");
        String room = scanner.nextLine();
        System.out.print("Type your massage: ");
        String text = scanner.nextLine();
        if (text.isEmpty())
            return;

        Message m = new Message();
        m.setText(text);
        m.setFrom(login);
        m.setTo(room);

        try {
            int res = m.send("http://localhost:8080/sendtoroom?room=" + room, cookie_name, cookie_value);
            if (res != 200) {
                System.out.println("HTTP error: " + res);
                return;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            return;
        }
    }

    private static String send(String url_name, boolean send_cookie)
    {
        try {
            URL url = new URL(url_name);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            if (send_cookie)
                http.setRequestProperty("Cookie", cookie_name + "=" + cookie_value);
             InputStream is = http.getInputStream();
            try {
                int sz = is.available();
                if (sz > 0)
                {
                    byte[] buf = new byte[is.available()];
                    is.read(buf);
                    String ret = new String(buf);

                    showHeader(http.getHeaderFields());
                    if (!send_cookie)
                        getSessionCookie(http);

                    if (ret != null)
                        return ret;
                }
            } finally {
                is.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    private static void showHeader(Map<String, List<String>> map)
    {
        System.out.print( "\n----------------------\n" );
        for (Map.Entry<String, List<String>> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey()
                    + " ,Value : " + entry.getValue());
        }
        System.out.print( "----------------------\n" );
    }

    private static void getSessionCookie(HttpURLConnection http)
    {
        String headerName = null;
        for (int i = 0; (headerName = http.getHeaderField(i)) != null; i++ )
        {
            if (headerName.length() < 10)
                continue;

            /*
            TODO: does not look good, entire client looks awful
             */
            cookie_name = headerName.substring(0, 10);
            if (cookie_name.equals("JSESSIONID")) {
                cookie_value = headerName.substring(11, 44);
                System.out.print( "\n----------------------\n" );
                System.out.print( "Cookie:\n" );
                System.out.print(cookie_name + ":" + cookie_value + "\n");
                System.out.print( "----------------------\n" );
                break;
            }

            cookie_name = cookie_value = null;
        }
    }

    private static void Info()
    {
        System.out.println("1 - send message to all\n" +
                           "2 - list users   \n"       +
                           "3 - send to      \n"       +
                           "4 - create room \n"        +
                           "5 - join room\n"           +
                           "6 - left room\n"           +
                           "7 - msg to room\n" );
    }
}
