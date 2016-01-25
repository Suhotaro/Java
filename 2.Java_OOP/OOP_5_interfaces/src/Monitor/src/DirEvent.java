package Monitor.src;

public class DirEvent implements IFileEvent {
    @Override
    public void onFileAdded(String s) {
        System.out.println("File added to dir: " + s);
    }
}