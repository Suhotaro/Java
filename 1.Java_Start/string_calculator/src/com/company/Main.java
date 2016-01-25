package com.company;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int length = -1;
        int result = 0, operand = 0;
        byte operation = -1;
        boolean swap = true;

        System.out.print("Enter string: ");
        String equation = scanner.nextLine();

        length = equation.length();

        for (int i = 0; i < equation.length(); i++)
        {
            int ch = equation.charAt(i);

            switch (ch)
            {
                case 43: /* '+' */
                    operation = 1;
                    swap = false;
                    break;

                case 45: /* '-' */
                    operation = 2;
                    swap = false;
                    break;

                case 42: /* '*' */
                    operation = 3;
                    swap = false;
                    break;

                case 47: /* '/' */
                    operation = 4;
                    swap = false;
                    break;

                case 48: /* 0 */
                case 49: /* 1 */
                case 50: /* 2 */
                case 51: /* 3 */
                case 52: /* 4 */
                case 53: /* 5 */
                case 54: /* 6 */
                case 55: /* 7 */
                case 56: /* 8 */
                case 57: /* 9 */

                    if( swap )
                        if( 0 == result )
                            result = ch - 48;
                        else
                        {
                            result *= 10;
                            result += ch - 48;
                        }
                    else
                    {
                        if( 0 == operand )
                            operand = ch - 48;
                        else
                        {
                            operand *= 10;
                            operand += ch - 48;
                        }
                    }

                    if ( 0 != operation && 0 != operand && (equation.length() > (i + 1) && 48 > equation.charAt(i+1)) || (i == equation.length() - 1))
                    {
                        switch (operation)
                        {
                            case 1: /* '+' */
                                result += operand;
                                operand = 0;
                                break;

                            case 2: /* '-' */
                                result -= operand;
                                break;

                            case 3: /* '*' */
                                result *= operand;
                                break;

                            case 4: /* '/' */
                                result /= operand;
                                break;
                        }

                        operand = 0;
                    }

                    break;

                default: /* bad symbols */
                    break;
            }
        }

        System.out.println("result: " + result);
    }
}
