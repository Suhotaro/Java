package Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;


public class StudentList {

    public class ListSizeExeption extends Exception
    {
        public ListSizeExeption(String message)
        {
            super(message);
        }

        @Override
        public String getMessage() {
            return "ListSizeExeption" + super.getMessage();
        }
    }

    public class WrongInputExeption extends Exception
    {
        public WrongInputExeption(String message)
        {
            super(message);
        }

        @Override
        public String getMessage() {
            return "WrongInputExeption" + super.getMessage();
        }
    }

    public class WrongDateExeption extends Exception
    {
        public WrongDateExeption(String message)
        {
            super(message);
        }

        @Override
        public String getMessage() {
            return "WrongInputExeption" + super.getMessage();
        }
    }


    private int size = 5;
    private Student[] list;
    private int num;

    private void pre_init()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input size of Students list: ");

        try {
            size = Integer.parseInt(reader.readLine());
            if (size <= 0)
                throw new ListSizeExeption("size cannot be negative or zero");

            list = new Student[size];

        }
        catch (NumberFormatException ex)
        {
            System.out.println("NumberFormatException");
        }
        catch (ListSizeExeption ex)
        {
            System.out.println("ListSizeExeption: " + ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println("IO Exeption");
        }
    }

    private void create_list_node()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Student " + num++ + ": ");

        try {
            String str = reader.readLine();

            String[] tokens = str.split(new String(" "));

            if ( 3 != tokens.length )
                throw new WrongInputExeption("WrongInputExeption");

            String tmp = tokens[2];
            String[] ddmmyyyy = tmp.split(new String(","));

            if ( 3 != ddmmyyyy.length )
                throw new WrongInputExeption("WrongInputExeption");

            if( 0 >= Integer.parseInt(ddmmyyyy[0]) ||  31 < Integer.parseInt(ddmmyyyy[0]) )
                throw new WrongDateExeption("WrongDateExeption");

            if( 0 >= Integer.parseInt(ddmmyyyy[1]) ||  12 < Integer.parseInt(ddmmyyyy[1]) )
                throw new WrongDateExeption("WrongDateExeption");

            add(new Student(tokens[0], tokens[1], new Date(Integer.parseInt(ddmmyyyy[0]), Integer.parseInt(ddmmyyyy[1]), Integer.parseInt(ddmmyyyy[2]))));
        }
        catch (WrongInputExeption ex) {
            System.out.println("Wrong Input");
        }
        catch (WrongDateExeption ex) {
            System.out.println("Wrong Date");
        }
        catch (IOException ex) {
            System.out.println("IO Exeption");
        }

        System.out.print("\n");
    }

    public void init()
    {
        pre_init();

        System.out.println("Template for input:");
        System.out.println("Name Surname Birth");
        for (int i = 0; i < size; i++ )
            create_list_node();
    }

    public boolean add(Student s) {
        for (int i = 0; i < size; i++) {
            if ( null == list[i])
            {
                list[i] = s;
                return true;
            }
        }
        return false;
    }

    public Student get(int n) {
        return list[n];
    }

    public int find(String name) {
        for (int i = 0; i < size; i++) {
            if ( null != list[i] && list[i].getName().equalsIgnoreCase(name))
                return i;
        }

        return -1;
    }

    public int findBySurname(String surname) {
        for (int i = 0; i < size; i++) {
            if ( null != list[i] && list[i].getSurname().equalsIgnoreCase(surname))
                return i;
        }

        return -1;
    }

    public int findByBirth(Date birth) {
        for (int i = 0; i < size; i++) {
            if ( null != list[i] && 0 == list[i].getBirth().compareTo(birth) )
                return i;
        }

        return -1;
    }

    public void delete(int indx) {
        list[indx] = null;
    }


}
