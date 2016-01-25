package Student;

import java.util.Date;

public class RunStudent {

    public RunStudent()
    {

    }

    public void run()
    {
        StudentList sl = new StudentList();

        sl.init();
        int n = sl.find("Eva");
        System.out.println("Hello " + sl.get(n).getName() + " " + sl.get(n).getSurname());

        sl.delete(1);
        sl.delete(1);
    }
}
