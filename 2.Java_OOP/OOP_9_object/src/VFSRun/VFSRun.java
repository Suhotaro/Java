package VFSRun;

import java.util.Iterator;
import java.util.LinkedList;

public class VFSRun {

    public void run()
    {
        VFS vfs = new VFS();

        vfs.addFile("A.txt");
        vfs.addFile("B.txt");
        vfs.addDir("dir_a");
        vfs.addFile("dir_a/C.pdf");
        vfs.addDir("dir_a/dri_b");
        vfs.addFile("dir_a/D.txt");
        vfs.addFile("E.jpeg");

        vfs.show();

        //vfs.delete("B.txt");

        //vfs.show();
    }
}

class VFS
{
    DirFile root;

    public VFS()
    {
        root = new DirFile("root", true);
    }

    public void addDir(String name)
    {
        root.addDirFile(name, true);
    }

    public void addFile(String name)
    {
        root.addDirFile(name, false);
    }

    public void delete(String name)
    {
        root.deleteDirFile(name);
    }

    public void show()
    {
        root.showContent();
    }
}


class DirFile
{
    private boolean isDir;
    private String name;

    private LinkedList<DirFile> content;

    public DirFile(String name, boolean isDir)
    {
        this.name = name;
        this.isDir = isDir;
        if(isDir)
            content = new LinkedList<DirFile>();
    }

    public void addDirFile(String name, boolean isDir)
    {
        String []list = name.split("/");

        if (1 == list.length) {
            DirFile node = new DirFile(name, isDir);
            content.add(node);
        }
        else
        {
            Iterator<DirFile> it = content.iterator();
            while (it.hasNext())
            {
                DirFile node = it.next();

                if (node.isDir() && list[0].equals(node.name))
                {
                    node.addDirFile(list[1], isDir);
                }
            }
        }
    }

    public void deleteDirFile(String name)
    {
        if(!isDir)
            return;

        Iterator<DirFile> it = content.iterator();
        while (it.hasNext())
        {
            if (name == it.next().name)
                content.remove(it);
        }
    }

    public void showContent()
    {
        if(!isDir)
            return;

        System.out.println(" " + name + ":");

        Iterator<DirFile> it = content.iterator();
        while (it.hasNext())
        {
            DirFile node = it.next();

            if (node.isDir())
                node.showContent();
            else
                System.out.println("  " + node.name);
        }
    }


    public boolean isDir() {return isDir;}
}

