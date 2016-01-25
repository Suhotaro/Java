package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int num = -1, mid = -1;
        boolean swap = true;
        String star = "*";


        System.out.print("please enter odd number: ");
        num = scanner.nextInt();

        while( 0 == num % 2 )
        {
            System.out.print("please enter odd number: ");
            num = scanner.nextInt();
        }


        mid = num / 2;

        for (int i = 0; i < num; i++)
        {
            if (swap)
            {
                for (int j = 0; j < mid - i; j++)
                    System.out.print(" ");

                for (int k = mid - i ; k <= mid + i; k++)
                    System.out.print(star);

                if( i == mid)
                    swap = false;
            }
            else
            {
                for (int j = 0; j < i - mid; j++)
                    System.out.print(" ");

                for (int k = i - mid;  k < mid + (num - i) ; k++)
                    System.out.print(star);
            }

            System.out.print("\n");
        }
    }
}


