package Main;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.Exception;

public class TaskTwo {
    public static void run()
    {
        Save.get(TextContainer.class);
    }
}

@Target (value= ElementType.METHOD)
@Retention (value= RetentionPolicy.RUNTIME)
@interface Saver {}

@Target (value= ElementType.TYPE)
@Retention (value= RetentionPolicy.RUNTIME)
@interface SaveTo
{
    String path() default "D:\\doc.txt";
}


@SaveTo(path = "D:\\file.txt")
class TextContainer
{
    public String text = "12345 abcde";

    @Saver
    public void save(String path, String data)
    {
        try
        {
            OutputStream to_file = new FileOutputStream(path);
            to_file.write(data.getBytes());

        }
        catch (FileNotFoundException ex)
        {
            ex.getStackTrace();
        }
        catch (IOException ex)
        {
            ex.getStackTrace();
        }
    }
}

class Save
{
    public static boolean get(Class<?>... ls) {
        try {
            for (Class<?> cls : ls) {

                if (!cls.isAnnotationPresent(SaveTo.class))
                    continue;

                System.out.println("Class name: " + cls.getName());

                String class_text_field = null;

                /* Fields */
                try
                {
                    Field field = cls.getDeclaredField("text");
                    field.setAccessible(true);

                    class_text_field = field.get(cls.newInstance()).toString();

                    System.out.println("data: " + class_text_field);
                }
                catch (Exception ex)
                {
                    ex.getStackTrace();
                }


                /* Methods */
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(Saver.class) && "save".equals(method.getName())) {

                        SaveTo annotation = cls.getAnnotation(SaveTo.class);

                        method.invoke(cls.newInstance(), annotation.path(), class_text_field);
                    }
                }
            }

            System.out.println("OK\n");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}