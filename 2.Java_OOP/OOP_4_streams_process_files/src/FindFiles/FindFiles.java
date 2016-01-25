package FindFiles;

import MyFile.MyFile;

import java.io.*;
import java.util.ArrayList;

class MyFindFiles {

    static class MyFileFilter implements FilenameFilter {
        private String ext;

        public MyFileFilter(String ext) {
            this.ext = ext;
        }

        public boolean accept(File dir, String name) {
            return name.endsWith(ext);
        }
    }

    public void findFiles(String srcPath, String ext, ArrayList<String> list) throws IOException {
        File dir = new File(srcPath);
        File[] files = dir.listFiles(new MyFileFilter(ext));

        for (int i = 0; i < files.length; i++) {
            list.add(srcPath + '\\' + files[i].getName());
        }
    }

    public void findFiles(String srcPath, String[] ext, ArrayList<String> list) throws IOException {
        File dir = new File(srcPath);

        for (int i = 0 ; i < ext.length; i++)
        {
            File[] files = dir.listFiles(new MyFileFilter(ext[i]));

            for (int j = 0; j < files.length; j++) {
                list.add(srcPath + '\\' + files[j].getName());
            }
        }

    }

    public void fileRW(String file_path){
        File f = new File(file_path);

        try
        {
            FileInputStream in = new FileInputStream(file_path);
            FileOutputStream out = new FileOutputStream("D:\\tmp\\tmp\\B.txt");

            byte [] buf = new byte[10];
            int r;

            do {
                r = in.read(buf,0,buf.length);

                if(r > 0)
                {
                    String str = new String(buf, "UTF-8");
                    str = str.replaceAll("HELLO", "12345");
                    buf = str.getBytes();

                    out.write(buf, 0, r);
                }
            } while ( r  > 0);

            out.close();
            in.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.print("Error" + ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.print("Error" + ex.getMessage());
        }
        finally {
            System.out.print("Out OK");
        }








    }

    public void recursive(String path) {
        File dir = new File(path);
        File[] list = dir.listFiles();

        try {
            for (File f : list) {
                if (f.isDirectory()) {
                    System.out.print("DIR: " + f.getCanonicalPath() + "\n");
                    recursive(f.getCanonicalPath());
                }
                else
                    System.out.print("FILE: " + f.getCanonicalPath() + "\n");
            }
        }
        catch(IOException ex)
        {
            System.out.print("Error: " + ex.getMessage());
        }
    }
}

public class FindFiles {
    public void run(){
        ArrayList<String> list = new ArrayList<String>();

        MyFindFiles find_files = new MyFindFiles();

        try {
            find_files.findFiles("D:\\tmp\\A\\B", ".txt", list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list)
            System.out.println(s);

        list.clear();

        System.out.println("\n" + "List of expretions:");
        String[] list_filter = {".txt", ".pdf"};
        try {
            find_files.findFiles("D:\\tmp\\A", list_filter, list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : list)
            System.out.println(s);

        System.out.println("\n" + "Recursive:");
        find_files.recursive("D:\\tmp");

        System.out.println("\n" + "File IO:");
        find_files.fileRW("D:\\tmp\\tmp\\AA.txt");
    }
}