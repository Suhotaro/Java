
public class FactoryPattern {
    public void run() {

        PersonFactory personFactory = new PersonFactory();

        Student student = (Student) personFactory.getPerson(PersonFactory.PERSON_EXCELLENT_STUDENT);
        System.out.println(student.getAverageMark());

        /* Work with student */

        OfficeWorker worker= (OfficeWorker) personFactory.getPerson(PersonFactory.PERSON_RICH_OFFICE_WORKER);
        System.out.println(worker.getSalary());

        /* Work with student */
    }
}

class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    private double averageMark;

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}

class OfficeWorker extends Person {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class PersonFactory {
    public static final int PERSON_EXCELLENT_STUDENT = 1;
    public static final int PERSON_RICH_OFFICE_WORKER = 2;

    public Person getPerson (int type) {
        if (type == PERSON_EXCELLENT_STUDENT) {
            Student res = new Student();
            res.setAverageMark(5);

            return res;
        }
        else if (type == PERSON_RICH_OFFICE_WORKER) {
            OfficeWorker res = new OfficeWorker();
            res.setSalary(1000000);

            return res;
        }

        return null;
    }
}
