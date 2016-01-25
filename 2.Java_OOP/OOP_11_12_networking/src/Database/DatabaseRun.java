package Database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class DatabaseRun {
    public void run()
    {
        DataBaseTop dbt = new DataBaseTop();
        dbt.run();
    }
}

class DataBaseTop {

    private static class Person implements Serializable {
        private static final long serialVersionUID = 1L;

        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    private static class Database implements Serializable {
        private static final long serialVersionUID = 1L;

        private int index;
        private HashMap<Integer, Person> map = new HashMap<Integer, Person>();

        public Database() {
            index = 0;
        }

        public int add(Person p) {
            map.put(index, p);
            return index++;
        }

        public Person get(int index) {
            return map.get(index);
        }

        public boolean delete(int index) {
            return map.remove(index) != null;
        }

        public void save(String file) throws IOException {
            FileOutputStream fo = new FileOutputStream(file);
            try {
                ObjectOutputStream oo = new ObjectOutputStream(fo);
                try {
                    oo.writeObject(this);
                } finally {
                    oo.close();
                }
            } finally {
                fo.flush();
                fo.close();
            }
        }

        public static Database load(String file) throws Exception {
            File f = new File(file);
            if ( ! f.exists())
                return new Database();

            FileInputStream fi = new FileInputStream(f);
            try {
                ObjectInputStream oi = new ObjectInputStream(fi);
                try {
                    return (Database) oi.readObject();
                } finally {
                    oi.close();
                }
            } finally {
                fi.close();
            }
        }
    }

    public static void run() {
        final String file = "database.db";

        try {
            BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
            Person p;
            int index;

            Database db = Database.load(file);

            try {
                while (true) {
                    System.out.println("Push:");
                    System.out.println("1 - to add a person");
                    System.out.println("2 - to delete");
                    System.out.println("3 - to search");
                    System.out.println("4 - to output info");
                    System.out.println("5 - Serialize");
                    System.out.println("6 - Deserialize");
                    System.out.println("Whatever else to quit");

                    String s = d.readLine();
                    int ch = Integer.parseInt(s);

                    switch (ch) {
                        case 1:
                            System.out.println("Person name:");
                            String name = d.readLine();
                            System.out.println("age:");
                            s = d.readLine();

                            int age = Integer.parseInt(s);

                            int id = db.add(new Person(name, age));

                            System.out.println("New Person has been added with ID = " + id);

                            break;
                        case 2:
                            System.out.println("Input person's ID:");
                            s = d.readLine();
                            index = Integer.parseInt(s);

                            if ( ! db.delete(index))
                                System.out.println("There is person wit this ID!");
                            else
                                System.out.println("OK!");

                            break;
                        case 3:
                            System.out.println("Input person's ID:");
                            s = d.readLine();
                            index = Integer.parseInt(s);

                            p = db.get(index);
                            if (p != null)
                                System.out.println("Person exists!");
                            else
                                System.out.println("There is person wit this ID!");

                            break;
                        case 4:
                            System.out.println("Input person's ID:");
                            s = d.readLine();
                            index = Integer.parseInt(s);

                            p = db.get(index);
                            if (p == null)
                                System.out.println("There is person wit this ID!");
                            else
                                System.out.println("Info: " + p.name + ", " + p.age);

                            break;

                        case 5:
                            System.out.println("Serialize:");
                            db.save("D:\\tmp\\DB");

                            break;

                        case 6:
                            System.out.println("Deserialize:");
                            Database new_db = Database.load("D:\\tmp\\DB");

                            System.out.println("Person: " + new_db.get(1).name + ", " + new_db.get(1).age);
                            System.out.println("Person: " + new_db.get(2).name + ", " + new_db.get(2).age);

                            break;

                        default:
                            return;
                    }
                }
            } finally {
                db.save(file);
            }
        } catch (Exception ex) {
            ;
        }
    }
}