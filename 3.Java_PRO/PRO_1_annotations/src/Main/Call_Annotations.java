package Main;

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.lang.reflect.Method;

@Inherited
@Target(value=ElementType.METHOD)
@Retention(value= RetentionPolicy.RUNTIME)
@interface MyTest{
    int a();
    int b();
}



public class Call_Annotations {
    public void run()
    {
        Tester2 tester2= new Tester2();
        tester2.test(Annot.class);
    }
}

class Annot
{
    @MyTest(a = 2, b = 5)
    public boolean abc(int a, int b)
    {
        System.out.println("aa:" + a + " bb: " + b);
        return true;
    }
}




class Tester2 {
    public static boolean test(Class<?>... ls) {
        try {
            for (Class<?> cls : ls) {
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(MyTest.class)) {

                        MyTest mt = method.getAnnotation(MyTest.class);
                        Boolean b = (Boolean) method.invoke(cls.newInstance(), mt.a(), mt.b());
                        if ( ! b)
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


