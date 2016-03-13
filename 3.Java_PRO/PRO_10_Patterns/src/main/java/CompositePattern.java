import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public void run() {
        VirtualFile file = new VirtualFile("file.dat", "content".getBytes());

        VirtualDirectory dir = new VirtualDirectory("dir");
        dir.add(new VirtualFile("file1.txt", "content1".getBytes()));
        dir.add(new VirtualFile("file2.txt", "content2".getBytes()));
        dir.add(new VirtualFile("file3.txt", "content3".getBytes()));

        file.list();
        dir.list();
    }
}

interface AbstractFile {
    String list();
}

class VirtualFile implements AbstractFile {
    private String name;
    private byte []content;

    public VirtualFile(String name, byte []content) {
        this.name = name;
        this.content = content;
    }

    public String list() {
        return name + ": " + new String(content);
    }
}

class VirtualDirectory implements AbstractFile {
    private String name;
    private List<AbstractFile> children = new ArrayList<AbstractFile>();

    public VirtualDirectory(String name) {
        this.name = name;
    }

    public void add(AbstractFile af) {
        children.add(af);
    }

    public String list() {
        StringBuilder sb = new StringBuilder();

        for (AbstractFile af : children)
            sb.append(af.list());

        return sb.toString();
    }
}