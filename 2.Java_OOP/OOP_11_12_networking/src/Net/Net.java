package Net;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Net
{


    public void run2()
    {
        try{
            URL url = new URL("http://prog.kiev.ua");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                char[] buf = new char[1000];
                StringBuilder sb = new StringBuilder();
                int r;
                do {
                    if ((r = br.read(buf)) > 0)
                        sb.append(new String(buf, 0, r));
                } while (r > 0);

                int count = 0;

                for (int i = 0; i < sb.length(); i++)
                {
                    char ch = sb.charAt(i);
                    switch (ch)
                    {
                        case 'h':
                        case 'r':
                        case 'e':
                        case 'f':
                        case '=':
                        case '"':
                            ++count;
                            if(7 == count) {
                                while ('\"' != sb.charAt(i)) {
                                    System.out.print(sb.charAt(i));
                                    ++i;
                                }
                                System.out.print("\n");
                            }
                            break;

                        default:
                            count = 0;
                            break;
                    }
                }




            } finally {
                http.disconnect();
            }
        }
        catch (MalformedURLException e)
        {
            e.getStackTrace();

        }
        catch (IOException e)
        {
            e.getStackTrace();
        }
    }
}