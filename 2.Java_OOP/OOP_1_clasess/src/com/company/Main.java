

package com.company;


import java.util.Arrays;
import Car.RunCar;
import Student.RunStudent;

public class Main {

    /****************************** Main *********************************/
    public static void main(String[] args)
    {
/*
        RunCar run_car = new RunCar();
        run_car.run();
*/

        /* ??? Explicit deletion of an object. Example is in deletion of the List members */
        RunStudent run_student = new RunStudent();
        run_student.run();
    }
}