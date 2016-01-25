package com.company;

import java.util.Arrays;

class Circle {
    public static String NAME = "Circle";
    private int radius;

    public Circle() {
        radius = 0;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public double getSquare()
    {
        return Math.pow(this.radius, 2) * 3.14;
    }
}

public class Main {

    /*****************************
     * Main
     *********************************/
    public static void main(String[] args) {
        /* Circle */
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(2);

        System.out.println(Circle.NAME);
        Circle.NAME = "Rect";
        System.out.println(Circle.NAME);


        System.out.println("  " + circle1.getSquare());
        System.out.println("  " + circle2.getSquare());

        System.out.println("\n");

    }
}

/*             game                        */

//        int []a = {1,2,2,2,4,6};
//        int []b = new int[6];
//
//        int max = a[0];
//        for(int i = 0; i < a.length; i++)
//        {
//            b[a[i] - 1] += a[i];
//            if(b[a[i] - 1] > max)
//                max = b[a[i] - 1];
//        }


/*              merge 2 arrays              */

//    static void merge(int[] a, int[] b)
//    {
//        int smaller = 1;
//        int max = a.length < b.length ? b.length :a.length ;
//        int min = a.length < b.length ? a.length : b.length ;
//
//        if(a.length > b.length)
//            smaller = 0;
//
//        int[] arr = new int[a.length + b.length];
//
//
//        for (int i = 0; i < max; i++)
//        {
//            if( 1== smaller)
//            {
//                if(i < min)
//                    arr[i] = a[i];
//
//                arr[i + min] = b[i];
//            }
//            else
//            {
//                arr[i] = a[i];
//
//                if(i < min)
//                    arr[i + max] = b[i];
//            }
//        }
//
//
//
//
//        for (int i = 0; i < max + min; i++)
//            System.out.print(arr[i] + " ");
//    }
