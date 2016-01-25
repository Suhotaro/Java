package com.company;

public class Main {

    public static void main(String[] args)
    {
        int[] arr = new int[]{5, 3, 7, 2, 4, 9, 8, 6, 10};

        int min = 0, max = -1;
        int start = 0;

        if ( 1 == arr.length%2 )
        {
            min = max = arr[0];
            start = 1;
        }
        else
        {
            if (arr[0] < arr[1])
            {
                min = arr[0];
                max = arr[1];
            }
            else
            {
                min = arr[1];
                max = arr[0];
            }

            start = 2;
        }

        for (int i = 0 + start; i < arr.length - 1; i += 2)
        {
            if (arr[i] < arr[i + 1])
            {
                if(arr[i] < min)
                    min = arr[i];

                if(arr[i + 1] > max)
                    max = arr[i + 1];
            }
            else
            {
                if(arr[i + 1] < min)
                    min = arr[i + 1];

                if(arr[i] > max)
                    max = arr[i];
            }
        }

        System.out.println("Min: " + min + " Max: " + max);


    }
}
