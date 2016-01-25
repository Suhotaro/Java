package Generic;


public class ContainerRun {

    public void run () {
        Container<String> c1 = new Container<String>();

        c1.setValue("Hello");
        System.out.println(c1.getValue());

        Container<Integer> c2 = new Container<Integer>();
        c2.setValue(5);
        System.out.println(c2.getValue());
    }


}


class Container<E> {
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
