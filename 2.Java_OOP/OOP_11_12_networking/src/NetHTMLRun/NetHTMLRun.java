package NetHTMLRun;

import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class NetHTMLRun {
    public void run()
    {
        NetHTML net_html = new NetHTML("http://prog.kiev.ua");
        net_html.putAllHTMLToDir("D:\\tmp");
    }
}

class NetHTML
{
    String html;

    public NetHTML(String html)
    {
        this.html = html;
    }

    public void putAllHTMLToDir(String dir){

        StringBuilder string_builder = new StringBuilder();

        getPage( this.html, string_builder);

        LinkedList<String> htmls_list = new LinkedList<String>();
        getHTMLS(string_builder, htmls_list);

        string_builder.setLength(0);

        toDir(dir, htmls_list);
    }

    /* privates*/
    private void getPage(String name, StringBuilder string_builder)
    {
        try {
            URL url = new URL(name);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            try{
                BufferedReader br = new BufferedReader( new InputStreamReader(http.getInputStream()));
                char[] buf = new char[1000];
                int r;

                do {
                    if (0 < (r = br.read(buf)))
                        string_builder.append(new String(buf, 0, r));
                } while( r > 0);
            }
            finally {
                http.disconnect();
            }
        }
        catch (MalformedURLException ex){
            ex.getStackTrace();
        }
        catch (IOException ex){
            ex.getStackTrace();
        }
    }

    private void getHTMLS(StringBuilder string_builder, LinkedList<String> htmls){

        int count = 0;

        for (int i = 0; i < string_builder.length(); i++) {
            char ch = string_builder.charAt(i);
            switch (ch) {
                case 'h':
                case 'r':
                case 'e':
                case 'f':
                case '=':
                case '"':
                    ++count;
                    if (7 == count) {

                        StringBuilder sb = new StringBuilder();

                        while ('\"' != string_builder.charAt(i)) {
                            sb.append(string_builder.charAt(i));
                            ++i;
                        }

                        htmls.add(sb.toString());
                        sb.setLength(0);
                    }
                    break;

                default:
                    count = 0;
                    break;
            }
        }
    }

    private void toDir(String dir, LinkedList<String> htmls_list)
    {
        int index = 1;
        for (int i = 0; i < htmls_list.size(); i++)
        {
            try{
                StringBuilder tmp = new StringBuilder();

                if ( !"".equals(htmls_list.get(i))) {
                    System.out.println( index + ": " + htmls_list.get(i));

                    File file = new File(dir + "\\" + index++ + "" + ".txt" );
                    file.createNewFile();

                    getPage(htmls_list.get(i), tmp);

                    FileOutputStream out = new FileOutputStream(file);
                    out.write(tmp.toString().getBytes());

                    out.close();
                }
            }
            catch (IOException ex){
                ex.getStackTrace();
            }
        }
    }
}
