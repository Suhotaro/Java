package Student;

import java.util.Date;

public class RunStudent {

    public RunStudent()
    {

    }

    public void run()
    {
        StudentList sl = new StudentList();

        if (!sl.add(new Student("Eva", "May", new Date(1986, 1, 1))))
            return;
        if (!sl.add(new Student("Aly", "Bin", new Date(1970, 3, 28))))
            return;
        if (!sl.add(new Student("Bob", "Morley", new Date(2000, 2, 2))))
            return;

        int n = sl.find("Eva");
        System.out.println(sl.get(n).getBirth().toString());

        int n2 = sl.findBySurname("Morley");
        System.out.println(sl.get(n2).getBirth().toString());

        sl.delete(1);

        if (!sl.add(new Student("Corey", "Woo", new Date(2001, 5, 5))))
            return;


        int n3 = sl.findBySurname("Mike");
        System.out.println(n3);

        Date date = new Date(1970, 3, 28);
        int n4 = sl.findByBirth(date);
        System.out.println(n4);
        System.out.println(sl.get(n4).getName());


    }



}
