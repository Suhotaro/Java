package Main;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.Exception.*;
import java.security.InvalidParameterException;


public class TaskThree {
    public static void run()
    {
        Human human_one = new Human("Bob", "Snow", 25, 180, 90);
        human_one.show();

        String data = MySerializeDeserialize.serialize(human_one);
        System.out.println(data);

        Human human_two = MySerializeDeserialize.deserialize(data, Human.class);
        human_two.show();
    }
}

@Target(value= ElementType.FIELD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface SaveFiled{}

class Human
{
    @SaveFiled String name;
    @SaveFiled String surname;

    @SaveFiled int age;
    @SaveFiled int height;
    @SaveFiled int weight;

    public Human()
    {

    }

    public Human(String name, String surname, int age, int height, int weight)
    {
        this.name = name;
        this.surname = surname;

        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public void show()
    {
        System.out.println(
                "Human: \n"   +
                "  name: "    + this.name    + "\n" +
                "  surname: " + this.surname + "\n" +
                "  age: "     + this.age     + "\n" +
                "  height: "  + this.height  + "\n" +
                "  weight: "  + this.weight  + "\n"
        );
    }
}

class MySerializeDeserialize
{
    public static String serialize(Object obj)
    {
        Class<?> cls = obj.getClass();
        StringBuilder sb =  new StringBuilder();

        Field[] fileds = cls.getDeclaredFields();

        for(Field f : fileds)
        {
            if ( ! f.isAnnotationPresent(SaveFiled.class))
                continue;

            if (Modifier.isPrivate(f.getModifiers()))
                f.setAccessible(true);

            sb.append(f.getName() + ":");

            try
            {
                if (f.getType() == int.class)
                    sb.append(f.getInt(obj));
                else if (f.getType() == String.class)
                    sb.append((String)f.get(obj));
            }
            catch (IllegalAccessException ex)
            {
                System.out.println("IllegalAccessException has been caught");

                sb.append("none");
            }

            sb.append(";");
        }

        return sb.toString();
    }

    public static <T> T deserialize(String data, Class<T> cls)
    {
        try
        {
            T ret_class = (T) cls.newInstance();
            String[] pairs = data.split(";");

            for(String p : pairs)
            {
                String[] field = p.split(":");
                if(field.length != 2)
                    throw new InvalidParameterException(data);

                String name = field[0];
                String value = field[1];

                Field f = cls.getDeclaredField(name);
                if (Modifier.isPrivate(f.getModifiers()))
                    f.setAccessible(true);

                if(f.isAnnotationPresent(SaveFiled.class))
                {
                    if (f.getType() == int.class)
                        f.setInt(ret_class, Integer.parseInt(value));
                    else if (f.getType() == String.class)
                        f.set(ret_class, (String)value);
                }
            }

            return ret_class;
        }

        catch (NumberFormatException ex) { ex.getStackTrace();}
        catch (IllegalAccessException ex) { ex.getStackTrace();}
        catch (InstantiationException ex) { ex.getStackTrace();}
        catch (NoSuchFieldException ex) { ex.getStackTrace();}

        return null;
    }
}


