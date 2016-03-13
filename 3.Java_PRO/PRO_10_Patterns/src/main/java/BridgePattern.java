import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BridgePattern {
    public void run() {
        Data[] data = {
                new PersonData("Name", 20, new SaveAPIFile()),
                new PointData(1, 2, new SaveAPIDatabase()),
        };

        for (Data d : data)
            d.save();
    }
}

interface SaveAPI {
    void save(byte []date);
}

class SaveAPIFile implements SaveAPI {
    public void save(byte [] data) {
        System.out.println("Save data to file");
    }
}

class SaveAPIDatabase implements SaveAPI {
    public void save(byte [] data) {
        System.out.println("Save data to database");
    }
}

abstract class Data {
    protected SaveAPI saveAPI;

    protected Data(SaveAPI saveAPI) {
        this.saveAPI = saveAPI;
    }

    public abstract void save();
}

class PersonData extends Data {
    private String name;
    private int age;

    public PersonData(String name, int age, SaveAPI saveAPI) {
        super(saveAPI);
        this.name = name;
        this.age = age;
    }

    public void save () {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bo);

        try{
            try{
                dos.writeChars(name);
                dos.writeInt(age);
            }finally {
                dos.close();
            }

            byte []data = bo.toByteArray();
            saveAPI.save(data);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class PointData extends Data {
    private double x, y;

    public PointData(double x, double y, SaveAPI saveAPI) {
        super(saveAPI);
        this.x = x;
        this.y = y;
    }

    public void save() {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(bo);
        try{
            try{
                dos.writeDouble(x);
                dos.writeDouble(y);
            }finally {
                dos.close();
            }

            byte []data = bo.toByteArray();
            saveAPI.save(data);
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
