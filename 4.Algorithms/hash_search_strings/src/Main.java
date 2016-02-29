public class Main {

    public static void main(String[] args)
    {

        hashString hs = new hashString(new String("123456789123456789123456789123456789123456789"), new String("123456789123456789123456789123456789123456789"));

        if (hs.equalsHashEqualLength())
            System.out.println("OK");
        else
            System.out.println("println");

        hs = new hashString(new String("123456789123456789123456789123456789123456789"), new String("123456789123456789124456789123456789123456789"));
        if (hs.equalsHashEqualLength())
            System.out.println("OK");
        else
            System.out.println("NO");

        hs = new hashString(new String("abcdef"), new String("123456789123456789123456789123456789123456789"));
        if (hs.equalsHashEqualLength())
            System.out.println("OK");
        else
            System.out.println("NO");

        hs = new hashString(new String("124444434"), new String("4444"));
        int res = hs.equalsHashByPattern();
        if ( res > 0 )
            System.out.println("Idx: " + res);
        else
            System.out.println("NO");
    }
}
