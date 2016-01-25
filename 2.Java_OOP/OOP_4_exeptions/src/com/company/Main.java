package com.company;

import OwnExeptions.OwnExeptions;
import ParseURL.ParseURL;
import Student.RunStudent;


public class Main {
/*
                         Object
                            |
                    Throwable(CHECKED)
                     /             \
            Error(UNCHECKED)     Exception(CHECKED)
                   |
        RuntimeException(UNCHECKED)
*/

    public static void main(String[] args) {

/*
        OwnExeptions o_exeption = new OwnExeptions();
        o_exeption.run();
*/

        /* Task 4.1 */
/*
        ParseURL pars_url = new ParseURL();
        try {
            pars_url.parse("para1=value1&para2=value2&para3=value3");
            pars_url.parse("para2=value2para3=value3");
            pars_url.parse("para2value2&para3=value3");
        }
        catch (ParseURL.URLExeption ex)
        {
            System.out.println("URL exeption");
        }
*/

        /* Task 4.5 4.3 4.4*/
        RunStudent run_student = new RunStudent();
        run_student.run();





    }
}
