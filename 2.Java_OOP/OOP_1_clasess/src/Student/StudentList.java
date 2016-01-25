package Student;

import java.util.Date;

public class StudentList {
    private static int SIZE = 5;
    private Student[] list = new Student[SIZE];

    public boolean add(Student s) {
        for (int i = 0; i < SIZE; i++) {
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
        for (int i = 0; i < SIZE; i++) {
            if ( null != list[i] && list[i].getName().equalsIgnoreCase(name))
                return i;
        }

        return -1;
    }

    public int findBySurname(String surname) {
        for (int i = 0; i < SIZE; i++) {
            if ( null != list[i] && list[i].getSurname().equalsIgnoreCase(surname))
                return i;
        }

        return -1;
    }

    public int findByBirth(Date birth) {
        for (int i = 0; i < SIZE; i++) {
            if ( null != list[i] && 0 == list[i].getBirth().compareTo(birth) )
                return i;
        }

        return -1;
    }

    public void delete(int indx) {
        list[indx] = null;
    }


}
