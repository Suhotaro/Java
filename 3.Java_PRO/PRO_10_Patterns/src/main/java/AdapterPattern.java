import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AdapterPattern {
    public void run()  {
        List<String> list = new BadListAdapter<String>();
        list.add("1234");
        String s = list.get(0);

        System.out.println(s);
    }
}

class BadList {
    private Object[] list = new Object[100];
    private int p;

    public void add(Object obj) {
        list[p++] = obj;
    }

    public Object get(int n) {
        return list[n];
    }

    public int getSize() {
        return p;
    }
}

class BadListAdapter<T> implements List<T> {
    private BadList badList = new BadList();

    public int size() {
        return badList.getSize();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T t) {
        badList.add(t);
        return true;
    }

    public T get(int i) {
        return (T) badList.get(i);
    }

    public void add(int index, T element) {

    }

    public boolean remove(Object o) {
        return false;
    }

    public T remove(int index) {
        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public void clear() {
        badList = null;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public boolean contains(Object o) {
        return false;
    }

    /******************************/
    public Object[] toArray() {
        return null;
    }

    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int i) {
        return null;
    }

    public int lastIndexOf(Object o) {
        return -1;
    }

    public int indexOf(Object o) {
        return -1;
    }
}