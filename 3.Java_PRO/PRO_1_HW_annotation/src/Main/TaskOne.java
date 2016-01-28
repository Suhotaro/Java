package Main;

import java.lang.reflect.Method;

import java.lang.annotation.*;

public class TaskOne {
    public static void run()
    {
        GetAnnotation get_annotation= new GetAnnotation();
        get_annotation.get(Annotation.class);
    }
}


@Inherited
@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    int param_one();
    int param_two();
}

class Annotation
{
    @MyAnnotation(param_one = 2, param_two = 5)
    public boolean abc(int a, int b)
    {
        System.out.println("param_one:" + a + " param_two: " + b);
        return true;
    }
}

class GetAnnotation {
    public static boolean get(Class<?>... ls) {
        try {
            for (Class<?> cls : ls) {
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(MyAnnotation.class)) {

                        MyAnnotation my_annotation = method.getAnnotation(MyAnnotation.class);
                        Boolean b = (Boolean) method.invoke(cls.newInstance(),
                                my_annotation.param_one(),
                                my_annotation.param_two());

                        if (!b)
                            return false;
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