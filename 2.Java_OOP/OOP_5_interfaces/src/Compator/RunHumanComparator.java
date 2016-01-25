package Compator;

import java.util.Arrays;
import java.util.Comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

class Human implements Comparable
{
    private int age;

    public Human(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object another)
    {
        Human h = (Human)another;

        if(age < h.age)
            return -1;
        else if(age == h.age)
            return 0;
        else if(age > h.age)
            return 1;
        else
            return 0;
    }

}

class HumanComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Human h1 = (Human) o1;
        Human h2 = (Human) o2;

        if(h1.getAge() < h2.getAge())
            return 1;
        else if(h1.getAge() == h2.getAge())
            return 0;
        else if(h1.getAge() > h2.getAge())
            return -1;

        return 0;
    }
}

public class RunHumanComparator
{
    public void run() {
        Human []list = {
                new Human(40),
                new Human(20),
                new Human(3),
                new Human(7),
        };

        Arrays.sort(list, new HumanComparator());

        for (Human h : list)
            System.out.println(h.getAge());
    }
}
