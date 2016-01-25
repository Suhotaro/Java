package Human;


import java.io.*;

public class HumanRun {
    public void run()
    {
        Human Bob = new Human(10, "male", "Good");
        Human Alice = new Human(12, "female", "Bad");
        Human Don = new Human(10, "male", "Normal");

        /* Hash */
        System.out.println("Hash code: " + Bob.hashCode());

        /* to Stirng */
        System.out.println("To String: " + Bob.toString());


        /* equals */
        System.out.println("human and human2 " + Bob.equals(Bob));
        System.out.println("human and human3 " + Bob.equals(Bob));

        /* clone */
        try
        {
            Human Bob_sun = (Human)Bob.clone();
            System.out.println("Cloned one: " + Bob_sun.getAge());
        }
        catch (CloneNotSupportedException ex)
        {
            ex.getStackTrace();
        }

        /* Serialization */
        try {
            FileOutputStream out = new FileOutputStream("human.txt");
            ObjectOutputStream o_out = new ObjectOutputStream(out);

            try {
                o_out.writeObject(Alice);
            }
            finally {
                o_out.close();
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.getStackTrace();
        }
        catch (IOException ex)
        {
            ex.getStackTrace();
        }

        Human none;
        try {
            FileInputStream in = new FileInputStream("human.txt");
            ObjectInputStream o_in = new ObjectInputStream(in);

            try {
                none = (Human)o_in.readObject();
                System.out.println("NONE: " + none.getAge());
            }
            finally {
                o_in.close();
            }
        }
        catch (FileNotFoundException ex)
        {
            ex.getStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.getStackTrace();
        }
        catch (IOException ex)
        {
            ex.getStackTrace();
        }
    }
}


class Human implements Serializable, Cloneable
{
    private int age;
    private String character;
    private String gender;

    public Human(int age, String gender, String character)
    {
        this.age = age;
        this.gender = gender;
        this.character = character;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public int hashCode ()
    {
        return age / age;
    }

    @Override
    public boolean equals(Object ob)
    {
        if (null == ob)
            return false;

        if (this == ob)
            return false;

        Human other = (Human)ob;
        return (getAge() == ((Human) ob).getAge());
    }

    @Override
    public String toString()
    {
        return age + "," + gender + "," + character;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        Human human = (Human) super.clone();

        return human;
    }
}
