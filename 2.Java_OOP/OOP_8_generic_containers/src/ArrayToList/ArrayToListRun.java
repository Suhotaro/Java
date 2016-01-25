package ArrayToList;


import java.util.Iterator;
import java.util.LinkedList;

public class ArrayToListRun {
    public void run()
    {
        /*Strings*/
        String []str_arr = {
                "One",
                "Two",
                "Three",
        };

        ArrayToList<String> converter_string = new ArrayToList<String>(str_arr);

        LinkedList<String> str_list = converter_string.process();
        Iterator<String> iterator_str = str_list.iterator();

        System.out.println("Strings:");
        while (iterator_str.hasNext())
            System.out.print(iterator_str.next() + " ");
        System.out.print("\n");

        /*Integers*/
        Integer []int_arr = {
                0,1,2,4,
                8,16,32,64,
                128,256,512,1024,
        };

        ArrayToList<Integer> converter_integer = new ArrayToList<Integer>(int_arr);
        LinkedList<Integer> int_list = converter_integer.process();

        Iterator<Integer> iterator_int = int_list.iterator();
        System.out.println("Integer:");
        while (iterator_int.hasNext())
            System.out.print(iterator_int.next() + " ");
        System.out.print("\n");

        /* Delete two first nodes and last one and show resault */
        int_list.remove(0);
        int_list.pop();
        int_list.pollLast();

        iterator_int = int_list.iterator();
        System.out.println("Two first and last numbers has been deleted:");
        while (iterator_int.hasNext())
            System.out.print(iterator_int.next() + " ");
        System.out.print("\n");

        System.out.println("Get by index");
        System.out.println("Integers: " + converter_integer.get(0));
        System.out.println("String: " + converter_string.get(1));


        str_list.pop();
        str_list.pop();
        str_list.pop();

        str_list.add("AAA");
        str_list.add("BBB");
        str_list.add("CCC ");


        System.out.println("String: " + converter_string.get(1));

    }
}

class ArrayToList<E>
{
    private E[]array;
    private LinkedList<E> list;

    public ArrayToList(E[] arr)
    {
        array = arr;
        list = new LinkedList<E>();
    }

    public LinkedList<E> process()
    {
        for (int i = 0; i < array.length; i++)
        {
            list.add(array[i]);
        }

        return list;
    }

    public E get(int idx)
    {
        return list.get(idx);
    }
}
