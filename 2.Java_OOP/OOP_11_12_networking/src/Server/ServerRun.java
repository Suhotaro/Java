package Server;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Properties;

public class ServerRun {
    public void run()
    {
        try{
            Server server = new Server(20000);
            server.start();
        }
        catch (IOException ex) {
            ex.getStackTrace();
        }
    }
}

class Server
{
    int port;
    int request = 0;
    Thread thread;


    public Server(int port)
    {
        this.port = port;
    }

    public void stop()
    {
        thread.interrupt();
    }

    public void start() throws IOException
    {
        thread = new Thread()
        {
            public void run()
            {
                try{
                    ServerSocket server_socket = new ServerSocket(port);

                    while(!isInterrupted())
                    {
                        Socket socket = server_socket.accept();
                        try{
                            ++request;

                            StringBuilder sb = new StringBuilder();
                            Properties properties = System.getProperties();

                            sb.append("Hello\r\n");
                            sb.append("  request: " + request + "\r\n");
                            sb.append("  date: " + (new Date()) + "\r\n");
                            sb.append("Info:\r\n");
                            byte []b = sb.toString().getBytes();

                            socket.getOutputStream().write(sb.toString().getBytes());


                            PrintStream ps = new PrintStream(socket.getOutputStream());
                            properties.list(ps);
                        }
                        finally {
                            socket.close();
                        }
                    }

                    server_socket.close();
                }
                catch (IOException ex){
                    ex.getStackTrace();
                }
            }
        };

        thread.start();
    }
}