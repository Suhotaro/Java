import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class StrategyPolicyPattern {

    public void run() {
        Human []list = {new Human(10, 30), new Human(20, 60), new Human(5, 20)};

        Arrays.sort(list, new Comparator<Human>() {
            public int compare(Human p1, Human p2) {
                return p1.getAge() - p2.getAge();
            }
        });

        Arrays.sort(list, new Comparator<Human>() {
            public int compare(Human p1, Human p2) {
                return p1.getWeight() - p2.getWeight();
            }
        });
    }
}

class Human {
    private int age;
    private int weight;

    public Human (int age, int weight) {
        this.age = age;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }
}